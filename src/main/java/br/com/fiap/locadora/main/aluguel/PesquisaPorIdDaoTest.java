package br.com.fiap.locadora.main.aluguel;

import br.com.fiap.locadora.connection.ConnectionFactory;
import br.com.fiap.locadora.dao.AluguelDao;
import br.com.fiap.locadora.model.Aluguel;

import javax.swing.*;
import java.sql.Connection;

public class PesquisaPorIdDaoTest {
    public static void main(String[] args) {

        //Perguntando o ID para o usuário
        int id = Integer.parseInt(JOptionPane.showInputDialog("Qual o id do aluguel?"));

        try {

            //Criando o DAO e a conexão com o banco de dados
            Connection conn = ConnectionFactory.getConnection();
            AluguelDao dao = new AluguelDao(conn);

            Aluguel aluguel = dao.pesquisaId(id);

            //Exibindo os dados do aluguel
            System.out.println(aluguel);

        } catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
}
