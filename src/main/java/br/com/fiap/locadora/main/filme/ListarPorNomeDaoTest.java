package br.com.fiap.locadora.main.filme;

import br.com.fiap.locadora.connection.ConnectionFactory;
import br.com.fiap.locadora.dao.FilmeDao;
import br.com.fiap.locadora.model.Filme;

import javax.swing.*;
import java.sql.Connection;
import java.util.List;

public class ListarPorNomeDaoTest {
    public static void main(String[] args) {

        //Pegar o nome do filme
        String nome = JOptionPane.showInputDialog("Insira o nome do filme");

        try {

            //Criando a conexão com o banco de dados e criando o DAO
            Connection conn = ConnectionFactory.getConnection();
            FilmeDao dao = new FilmeDao(conn);

            //Lista de exibição
            List<Filme> lista = dao.pesquisaNome(nome);

            for (Filme f : lista){
                System.out.println(f + "\n");
            }
            System.out.println("Filmes encontrados: " + lista.size());

        } catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
}
