package br.com.fiap.locadora.main.funcionario;

import br.com.fiap.locadora.connection.ConnectionFactory;
import br.com.fiap.locadora.dao.FuncionarioDao;

import javax.swing.*;

public class DeleteDaoTest {
    public static void main(String[] args) {

        //Pedindo o id para o usuário
        int id = Integer.parseInt(JOptionPane.showInputDialog("Insira o id do funcionário que você deseja deletar"));

        try {

            //Setando o DAO e a conexão com o banco de dados
            FuncionarioDao dao = new FuncionarioDao(ConnectionFactory.getConnection());

            dao.apagar(id);
            System.out.println("Funcionário deletado com sucesso!");
        } catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
}
