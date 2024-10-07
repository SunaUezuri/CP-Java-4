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

public class UpdateDaoTest {
    public static void main(String[] args) {

        //Pedindo os dados para o cliente
        int idAluguel = Integer.parseInt(JOptionPane.showInputDialog("Qual o id do aluguel do qual você deseja atualizar?"));
        int idFilme = Integer.parseInt(JOptionPane.showInputDialog("Qual o id do filme?"));
        int idCliente = Integer.parseInt(JOptionPane.showInputDialog("Qual o id do cliente?"));
        String dtAluguel = JOptionPane.showInputDialog("Qual a data do aluguel?");
        String dtDevolucao = JOptionPane.showInputDialog("Qual a data de devolução?");

        //Instanciando um aluguel
        Aluguel aluguel = new Aluguel(idAluguel, dtAluguel, dtDevolucao);

        try {

            //Criando a conexão do banco de dados e os DAO's
            Connection conn = ConnectionFactory.getConnection();
            AluguelDao aluguelDao = new AluguelDao(conn);
            FilmeDao filmeDao = new FilmeDao(conn);
            ClienteDao clienteDao = new ClienteDao(conn);

            //Setando os id do filme e do cliente
            Filme filme = filmeDao.pesquisaID(idFilme);
            aluguel.setFilme(filme);

            Cliente cliente = clienteDao.pesquisaId(idCliente);
            aluguel.setCliente(cliente);

            //Executando a atualização
            aluguelDao.update(aluguel);
            System.out.println("Update realizado com sucesso!");

        } catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
}
