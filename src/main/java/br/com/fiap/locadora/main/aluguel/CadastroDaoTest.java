package br.com.fiap.locadora.main.aluguel;

import br.com.fiap.locadora.connection.ConnectionFactory;
import br.com.fiap.locadora.dao.AluguelDao;
import br.com.fiap.locadora.dao.ClienteDao;
import br.com.fiap.locadora.dao.FilmeDao;
import br.com.fiap.locadora.model.Aluguel;
import br.com.fiap.locadora.model.Cliente;
import br.com.fiap.locadora.model.Filme;

import javax.swing.*;
import java.sql.Connection;

public class CadastroDaoTest {
    public static void main(String[] args) {

        //Pedindo os dados para o usuário
        int idCliente = Integer.parseInt(JOptionPane.showInputDialog("Qual o ID do cliente que está alugando?"));
        int idFilme = Integer.parseInt(JOptionPane.showInputDialog("Qual o ID do filme alugado?"));
        String dtAluguel = JOptionPane.showInputDialog("Qual a data em que foi alugado?");
        String devolucao = JOptionPane.showInputDialog("Qual a data de devolução?");

        Aluguel aluguel = new Aluguel(dtAluguel, devolucao);

        try {

            //Criando o DAO e a conexão com o banco de dados
            Connection conn = ConnectionFactory.getConnection();
            AluguelDao aluguelDao = new AluguelDao(conn);

            //Pesquisando e setando a FK id_cliente
            ClienteDao clienteDao = new ClienteDao(conn);
            Cliente cliente = clienteDao.pesquisaId(idCliente);
            aluguel.setCliente(cliente);

            //Pesquisando e setando a FK id_filme
            FilmeDao filmeDao = new FilmeDao(conn);
            Filme filme = filmeDao.pesquisaID(idFilme);
            aluguel.setFilme(filme);

            //Executando o cadastro
            aluguelDao.cadastrar(aluguel);
            System.out.println("Filme " + aluguel.getFilme().getNome() +
                    " alugado com sucesso por: " + aluguel.getCliente().getNome());

        } catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
}
