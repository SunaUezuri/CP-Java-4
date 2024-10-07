package br.com.fiap.locadora.main.funcionario;

import br.com.fiap.locadora.connection.ConnectionFactory;
import br.com.fiap.locadora.dao.FuncionarioDao;
import br.com.fiap.locadora.model.Funcionario;

import javax.swing.*;
import java.util.List;

public class ListarPorLocadoraDaoTest {
    public static void main(String[] args) {

        //Pedindo o id ca locadora ao usuário
        int idConcess = Integer.parseInt(JOptionPane.showInputDialog("Qual a locadora que você deseja " +
                "ver os funcionários?"));

        try {

            //Criando o DAO e a conexão com o banco de dados
            FuncionarioDao dao = new FuncionarioDao(ConnectionFactory.getConnection());

            //Criando a lista de exibição e exibindo os dados encontrados
            List<Funcionario> lista = dao.pesquisaPorLocadora(idConcess);

            for (Funcionario f : lista){
                System.out.println(f + "\n");
            }
            System.out.println("Funcionários que trabalham nessa locadora: " + lista.size());
        } catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
}
