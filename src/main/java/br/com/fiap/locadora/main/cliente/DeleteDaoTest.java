package br.com.fiap.locadora.main.cliente;

import br.com.fiap.locadora.connection.ConnectionFactory;
import br.com.fiap.locadora.dao.ClienteDao;

import javax.swing.*;
import java.sql.Connection;

public class DeleteDaoTest {
    public static void main(String[] args) {

        //Pedir o ID ao usuário
        int id = Integer.parseInt(JOptionPane.showInputDialog("Insira o ID do cliente que você deseja deletar: "));

        try {

            //Criando a conexão com o banco e instanciando o DAO do cliente
            Connection conn = ConnectionFactory.getConnection();
            ClienteDao dao = new ClienteDao(conn);

            //Executando o delete
            dao.apagar(id);
            System.out.println("Cliente apagado com sucesso!");
        } catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
}
