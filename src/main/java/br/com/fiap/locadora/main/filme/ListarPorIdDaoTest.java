package br.com.fiap.locadora.main.filme;

import br.com.fiap.locadora.connection.ConnectionFactory;
import br.com.fiap.locadora.dao.FilmeDao;
import br.com.fiap.locadora.model.Filme;

import javax.swing.*;
import java.sql.Connection;

public class ListarPorIdDaoTest {
    public static void main(String[] args) {

        //Perguntar o ID ao usuário
        int id = Integer.parseInt(JOptionPane.showInputDialog("Insira o ID do filme desejado"));

        try {

            //Criando a conexão com o banco e a classe DAO
            Connection conn = ConnectionFactory.getConnection();
            FilmeDao dao = new FilmeDao(conn);

            Filme filme = dao.pesquisaID(id);

            //Exibindo os dados encontrados
            System.out.println(filme);

        } catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
}
