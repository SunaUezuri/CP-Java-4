package br.com.fiap.locadora.main.cliente;

import br.com.fiap.locadora.connection.ConnectionFactory;
import br.com.fiap.locadora.dao.ClienteDao;
import br.com.fiap.locadora.model.Cliente;

import javax.swing.*;
import java.sql.Connection;

public class BuscarIdDaoTest {
    public static void main(String[] args) {

        //Perguntar o ID que quer pesquisar
        int id = Integer.parseInt(JOptionPane.showInputDialog("Insira o ID que deseja pesquisar: "));

        try {

            //Criando a conexão com o banco dados
            Connection conn = ConnectionFactory.getConnection();
            ClienteDao dao = new ClienteDao(conn);

            Cliente cliente = dao.pesquisaId(id);

            //Exibindo os dados encontrados
            System.out.println(cliente);

        } catch (Exception e){
            System.err.println(e.getMessage());
        }

    }
}
