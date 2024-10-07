package br.com.fiap.locadora.main.locadora;

import br.com.fiap.locadora.connection.ConnectionFactory;
import br.com.fiap.locadora.dao.LocadoraDao;
import br.com.fiap.locadora.model.Locadora;

import javax.swing.*;
import java.sql.Connection;
import java.util.List;

public class PesquisaEnderecoDaoTest {
    public static void main(String[] args) {

        //Pedir o endereço ao usuário
        String endereco = JOptionPane.showInputDialog("Insira o endereço do qual você deseja ver as locadoras");

        try {

            //Criando a conexão com o banco e o DAO
            Connection conn = ConnectionFactory.getConnection();
            LocadoraDao dao = new LocadoraDao(conn);

            //Criando a lista para exibir as informações
            List<Locadora> lista = dao.pesquisaEndereco(endereco);

            for (Locadora l : lista){
                System.out.println(l + "\n");
            }
            System.out.println("\nLocadoras encontradas: " + lista.size());
        } catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
}
