package br.com.fiap.locadora.main.aluguel;

import br.com.fiap.locadora.connection.ConnectionFactory;
import br.com.fiap.locadora.dao.AluguelDao;
import br.com.fiap.locadora.model.Aluguel;

import javax.swing.*;
import java.sql.Connection;
import java.util.List;

public class PesquisaIdFilme {
    public static void main(String[] args) {

        //Pedir o ID do filme
        int idFilme = Integer.parseInt(JOptionPane.showInputDialog("Qual o id do filme?"));

        try {

            //Criando o DAO e a conexão com o banco de dados
            Connection conn = ConnectionFactory.getConnection();
            AluguelDao dao = new AluguelDao(conn);

            List<Aluguel> lista = dao.pesquisaIdFilme(idFilme);

            //Exibindo os dados do aluguel
            for (Aluguel a : lista){
                System.out.println(a + "\n");
            }
            System.out.println("Quantidade de aluguéis encontrados: " + lista.size());

        } catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
}
