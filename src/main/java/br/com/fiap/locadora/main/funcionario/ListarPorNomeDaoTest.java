package br.com.fiap.locadora.main.funcionario;

import br.com.fiap.locadora.connection.ConnectionFactory;
import br.com.fiap.locadora.dao.FuncionarioDao;
import br.com.fiap.locadora.model.Funcionario;

import javax.swing.*;
import java.util.List;

public class ListarPorNomeDaoTest {
    public static void main(String[] args) {

        //Pedir o nome ao usuário
        String nome = JOptionPane.showInputDialog("Qual o nome do funcionário?");

        try {

            //Criando a conexão com o banco e o DAO de Funcionário
            FuncionarioDao dao = new FuncionarioDao(ConnectionFactory.getConnection());

            //Criando a lista de exibição
            List<Funcionario> lista = dao.pesquisaNome(nome);

            for (Funcionario f : lista){
                System.out.println(f + "\n");
            }
            System.out.println("Funcionários encontrados: " + lista.size());

        } catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
}
