package br.com.fiap.locadora.main.filme;

import br.com.fiap.locadora.connection.ConnectionFactory;
import br.com.fiap.locadora.dao.FilmeDao;
import br.com.fiap.locadora.model.Filme;

import javax.swing.*;
import java.sql.Connection;
import java.util.List;

public class ListarPorGeneroDaoTest {
    public static void main(String[] args) {

        //Pedir o gênero que o usuário quer ver
        String genero = JOptionPane.showInputDialog("Qual gênero você gostaria de pesquisar?");

        try {

            //Criando a conexão e o dao
            Connection conn = ConnectionFactory.getConnection();
            FilmeDao dao = new FilmeDao(conn);

            //Criando a lista de exibição
            List<Filme> lista = dao.pesquisaGenero(genero);

            for (Filme f : lista){
                System.out.println(f + "\n");
            }
            System.out.println("Filmes encontrados: " + lista.size());

        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
