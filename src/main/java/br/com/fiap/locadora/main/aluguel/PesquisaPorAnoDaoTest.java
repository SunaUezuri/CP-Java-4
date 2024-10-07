package br.com.fiap.locadora.main.aluguel;

import br.com.fiap.locadora.connection.ConnectionFactory;
import br.com.fiap.locadora.dao.AluguelDao;
import br.com.fiap.locadora.model.Aluguel;

import javax.swing.*;
import java.sql.Connection;
import java.util.List;

public class PesquisaPorAnoDaoTest {
    public static void main(String[] args) {

        //Pedindo a data de devolução do aluguel
        String dtDevolucao = JOptionPane.showInputDialog("Qual a data de devolução?");

        try {

            //Criando a conexão com o banco de dados e o DAO do aluguel
            Connection conn = ConnectionFactory.getConnection();
            AluguelDao dao = new AluguelDao(conn);

            //Criando a lista de exibição
            List<Aluguel> lista = dao.pesquisaDtDevolucao(dtDevolucao);

            for (Aluguel a : lista){
                System.out.println(a + "\n");
            }
            System.out.println("Aluguéis encontrados: " + lista.size());

        } catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
}
