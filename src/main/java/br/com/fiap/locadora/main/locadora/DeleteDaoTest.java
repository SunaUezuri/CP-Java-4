package br.com.fiap.locadora.main.locadora;

import br.com.fiap.locadora.connection.ConnectionFactory;
import br.com.fiap.locadora.dao.LocadoraDao;

import javax.swing.*;
import java.sql.Connection;

public class DeleteDaoTest {
    public static void main(String[] args) {

        //Pedindo o id para o usuário
        int id = Integer.parseInt(JOptionPane.showInputDialog("Insira o ID da locadora que deseja deletar"));

        try {

            //Criando a conexão do banco e o dao
            Connection conn = ConnectionFactory.getConnection();
            LocadoraDao dao = new LocadoraDao(conn);

            //Executando o delete
            dao.apagar(id);
            System.out.println("Locadora deletada com sucesso!");

        } catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
}
