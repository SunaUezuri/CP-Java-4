package br.com.fiap.locadora.main.aluguel;

import br.com.fiap.locadora.connection.ConnectionFactory;
import br.com.fiap.locadora.dao.AluguelDao;

import javax.swing.*;
import java.sql.Connection;

public class DeleteDaoTest {
    public static void main(String[] args) {

        //Pedindo o id para o usuário
        int id = Integer.parseInt(JOptionPane.showInputDialog("Insira o ID do aluguel que deseja deletar"));

        try {

            //Criando a conexão do banco e o dao
            Connection conn = ConnectionFactory.getConnection();
            AluguelDao dao = new AluguelDao(conn);

            //Executando o delete
            dao.deletar(id);
            System.out.println("Filme deletado com sucesso!");

        } catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
}
