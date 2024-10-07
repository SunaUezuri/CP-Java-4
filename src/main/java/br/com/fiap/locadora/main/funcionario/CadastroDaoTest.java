package br.com.fiap.locadora.main.funcionario;

import br.com.fiap.locadora.connection.ConnectionFactory;
import br.com.fiap.locadora.dao.FuncionarioDao;
import br.com.fiap.locadora.dao.LocadoraDao;
import br.com.fiap.locadora.model.Funcionario;
import br.com.fiap.locadora.model.Locadora;

import javax.swing.*;
import java.sql.Connection;

public class CadastroDaoTest {
    public static void main(String[] args) {

        //Pedir as informações ao usuário
        String cpf = JOptionPane.showInputDialog("Insira seu CPF: ");
        String nome = JOptionPane.showInputDialog("Insira seu nome: ");
        String dtNasc = JOptionPane.showInputDialog("Insira sua data de nascimento: ");
        int anoAdmissao = Integer.parseInt(JOptionPane.showInputDialog("Em qual ano este funcionário foi contratado?"));
        int idLoca = Integer.parseInt(JOptionPane.showInputDialog("Qual o id da locadora em que " +
                "esse funcionário trabalha?"));


        try {

            //Criando a conexão com o banco e o DAO do Funcionário
            Connection conn = ConnectionFactory.getConnection();
            FuncionarioDao dao = new FuncionarioDao(conn);

            Funcionario funcionario = new Funcionario(cpf, nome, dtNasc, anoAdmissao);

            LocadoraDao locaDao = new LocadoraDao(conn);
            Locadora locadora = locaDao.pesquisaId(idLoca);
            funcionario.setLocadora(locadora);


            dao.cadastrar(funcionario);
            System.out.println("Funcionário " + funcionario.getNome() + " cadastrado com sucesso!");

        } catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
}
