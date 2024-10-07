package br.com.fiap.locadora.main.locadora;

import br.com.fiap.locadora.connection.ConnectionFactory;
import br.com.fiap.locadora.dao.LocadoraDao;
import br.com.fiap.locadora.model.Locadora;

import javax.swing.*;
import java.sql.Connection;
import java.util.List;

public class PesquisaPorNomeDaoTest {
    public static void main(String[] args) {

        //Pedir o nome da locadora desejada
        String nome = JOptionPane.showInputDialog("Insira o nome da Locadora que você deseja pesquisar");

        try {

            //Criando a conexão com o banco e instanciando o DAO
            Connection conn = ConnectionFactory.getConnection();
            LocadoraDao dao = new LocadoraDao(conn);

            List<Locadora> lista = dao.pesquisarNome(nome);

            //Percorrendo o método e imprimindo os valores encontrados
            for (Locadora l : lista){
                System.out.println(l + "\n");
            }
            System.out.println("\nLocadoras encontradas: " + lista.size());

        } catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
}
