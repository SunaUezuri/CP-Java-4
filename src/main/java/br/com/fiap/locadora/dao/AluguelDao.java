package br.com.fiap.locadora.dao;

import br.com.fiap.locadora.exceptions.DataNaoEncontradaException;
import br.com.fiap.locadora.exceptions.IdNaoEncontradoException;
import br.com.fiap.locadora.model.Aluguel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AluguelDao {

    private Connection conexao;

    public AluguelDao(Connection conexao){this.conexao = conexao;}

    //Método para cadastrar um aluguel e relacionar um filme e um cliente
    public void cadastrar(Aluguel aluguel) throws SQLException{

        //Criando o PreparedStatement
        PreparedStatement stmt = conexao.prepareStatement("insert into t_aluguel values " +
                "(sq_t_aluguel.nextval, ?, ?, ?, ?)");

        //Configurando os valores na querry
        stmt.setInt(1, aluguel.getFilme().getId());
        stmt.setInt(2, aluguel.getCliente().getId());
        stmt.setString(3, aluguel.getDtAluguel());

        if (aluguel.getDtDevolucao() != null){
            stmt.setString(4, aluguel.getDtDevolucao());
        } else {
            stmt.setNull(4, Types.VARCHAR);
        }

        stmt.executeUpdate();
    }

    public List<Aluguel> listar() throws SQLException{

        //Criando o Statement
        Statement stm = conexao.createStatement();

        //Executando o comando SQL
        ResultSet resultSet = stm.executeQuery("select * from t_aluguel order by id_aluguel");

        //Criando a lista de aluguéis
        List<Aluguel> lista = new ArrayList<>();

        while (resultSet.next()){
            Aluguel aluguel = parseAluguel(resultSet);
            lista.add(aluguel);
        }

        return lista;
    }

    //Recuperar um aluguel pelo ID
    public Aluguel pesquisaId(int id) throws SQLException, IdNaoEncontradoException{

        //Criando o PreparedStatement
        PreparedStatement stmt = conexao.prepareStatement("select * from t_aluguel where id_aluguel = ?");

        //Setando o valor na querry
        stmt.setInt(1, id);

        //Executar o comando SQL
        ResultSet resultSet = stmt.executeQuery();

        //Lançando uma exceção caso não encontre o ID
        if (!resultSet.next()){
            throw new IdNaoEncontradoException("Aluguel não encontrado.");
        }

        return parseAluguel(resultSet);
    }

    //Pesquisando um aluguel pelo ID do cliente
    public List<Aluguel> pesquisaIdCliente(int idCliente) throws SQLException, IdNaoEncontradoException{

        //Criando o PreparedStatement
        PreparedStatement stmt = conexao.prepareStatement("select * from t_aluguel where id_cliente = ?");

        //Setando o valor na querry
        stmt.setInt(1, idCliente);

        //Executar o comando SQL
        ResultSet resultSet = stmt.executeQuery();

        //Criando a lista de exibição
        List<Aluguel> lista = new ArrayList<>();

        while (resultSet.next()){
            Aluguel aluguel = parseAluguel(resultSet);
            lista.add(aluguel);
        }

        //Lançando uma exceção caso não encontre o ID
        if (lista.isEmpty()){
            throw new IdNaoEncontradoException("Aluguel não encontrado, ou este cliente " +
                    "não possui aluguéis no momento.");
        }

        return lista;
    }

    //Pesquisando um aluguel pelo ID do filme
    public List<Aluguel> pesquisaIdFilme(int idFilme) throws SQLException, IdNaoEncontradoException{

        //Criando o PreparedStatement
        PreparedStatement stmt = conexao.prepareStatement("select * from t_aluguel where id_filme = ?");

        //Setando o valor na querry
        stmt.setInt(1, idFilme);

        //Executar o comando SQL
        ResultSet resultSet = stmt.executeQuery();

        //Criando a lista de exibição
        List<Aluguel> lista = new ArrayList<>();

        while (resultSet.next()){
            Aluguel aluguel = parseAluguel(resultSet);
            lista.add(aluguel);
        }

        //Lançando uma exceção caso não encontre o ID
        if (lista.isEmpty()){
            throw new IdNaoEncontradoException("Aluguel não encontrado, ou este cliente " +
                    "não possui aluguéis no momento.");
        }

        return lista;
    }

    //Pesquisar os aluguéis pela Data de devolução
    public List<Aluguel> pesquisaDtDevolucao(String data) throws SQLException, DataNaoEncontradaException{

        //Criando o PreparedStatement
        PreparedStatement stmt = conexao.prepareStatement("select * from t_aluguel " +
                "where dt_devolucao like ? order by id_aluguel");

        //Setando o valor na querry
        stmt.setString(1, "%" + data + "%");

        ResultSet resultSet = stmt.executeQuery();

        //Criando a lista para salvar os aluguéis
        List<Aluguel> lista = new ArrayList<>();

        //Salvando os dados em um objeto da classe aluguel
        while (resultSet.next()){
            Aluguel aluguel = parseAluguel(resultSet);
            lista.add(aluguel);
        }

        if (lista.isEmpty()){
            throw new DataNaoEncontradaException("Nenhum aluguel está pendente para esta data.");
        }

        return lista;
    }

    //Método para dar update em um aluguel
    public void update(Aluguel aluguel) throws SQLException, IdNaoEncontradoException{

        //Criando o PreparedStatement
        PreparedStatement stmt = conexao.prepareStatement("update t_aluguel set id_filme = ?, id_cliente = ?, " +
                "dt_aluguel = ?, dt_devolucao = ? where id_aluguel = ?");

        //Setando os valores na querry
        stmt.setInt(1, aluguel.getFilme().getId());
        stmt.setInt(2, aluguel.getCliente().getId());
        stmt.setString(3, aluguel.getDtAluguel());
        stmt.setString(4, aluguel.getDtDevolucao());
        stmt.setInt(5, aluguel.getId());

        //Executando o comando SQL caso o ID seja encontrado

        int linhas = stmt.executeUpdate();

        if (linhas == 0){
            throw new IdNaoEncontradoException("Aluguel não encontrado.");
        }
    }

    //Método para deletar um aluguel
    public void deletar(int id) throws SQLException, IdNaoEncontradoException{

        //Criando o PreparedStatemente
        PreparedStatement stmt = conexao.prepareStatement("delete from t_aluguel where id_aluguel = ?");

        //Setando o valor na querry
        stmt.setInt(1, id);

        //Executando o comando SQL caso o id seja válido
        int linhas = stmt.executeUpdate();

        if (linhas == 0){
            throw new IdNaoEncontradoException("Aluguel não encontrado.");
        }
    }

    private Aluguel parseAluguel(ResultSet resultSet) throws SQLException{
        int id = resultSet.getInt("id_aluguel");
        String dtAluguel = resultSet.getString("dt_aluguel");
        String dtDevolucao = resultSet.getString("dt_devolucao");

        //Criando o objeto do aluguel
        Aluguel aluguel = new Aluguel(id, dtAluguel, dtDevolucao);

        return aluguel;
    }
}
