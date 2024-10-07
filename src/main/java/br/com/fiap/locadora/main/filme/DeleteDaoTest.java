package br.com.fiap.locadora.main.filme;

import br.com.fiap.locadora.connection.ConnectionFactory;
import br.com.fiap.locadora.dao.FilmeDao;

import javax.swing.*;
import java.sql.Connection;

public class DeleteDaoTest {
    public static void main(String[] args) {

        //Pedindo o id para o usuário
        int id = Integer.parseInt(JOptionPane.showInputDialog("Insira o ID do filme que deseja deletar"));

        try {

            //Criando a conexão do banco e o dao
            Connection conn = ConnectionFactory.getConnection();
            FilmeDao dao = new FilmeDao(conn);

            //Executando o delete
            dao.apagar(id);
            System.out.println("Filme deletado com sucesso!");

        } catch (Exception e){
            System.err.println(e.getMessage());
        }
    }

}
