package br.com.fiap.locadora.main.funcionario;

import br.com.fiap.locadora.connection.ConnectionFactory;
import br.com.fiap.locadora.dao.FuncionarioDao;
import br.com.fiap.locadora.model.Funcionario;

import javax.swing.*;
import java.sql.Connection;

public class PesquisarPorIdDaoTest {
    public static void main(String[] args) {

        //Pedir o id para o usuário
        int id = Integer.parseInt(JOptionPane.showInputDialog("Insira o ID do funcionário"));

        try {

            //Criando a conexão com o banco e o DAO da locadora
            Connection conn = ConnectionFactory.getConnection();
            FuncionarioDao dao = new FuncionarioDao(conn);

            Funcionario funcionario = dao.pesquisarId(id);

            //Exibindo os dados pesquisados
            System.out.println(funcionario);

        } catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
}
