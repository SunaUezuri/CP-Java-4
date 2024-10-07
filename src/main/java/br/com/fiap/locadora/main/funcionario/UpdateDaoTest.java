package br.com.fiap.locadora.main.funcionario;

import br.com.fiap.locadora.connection.ConnectionFactory;
import br.com.fiap.locadora.dao.FuncionarioDao;
import br.com.fiap.locadora.dao.LocadoraDao;
import br.com.fiap.locadora.model.Funcionario;
import br.com.fiap.locadora.model.Locadora;

import javax.swing.*;
import java.sql.Connection;

public class UpdateDaoTest {
    public static void main(String[] args) {

        //Pedir os dados para o usuário
        int id = Integer.parseInt(JOptionPane.showInputDialog("Qual o id do funcionário que você deseja modificar?"));
        String cpf = JOptionPane.showInputDialog("Insira o novo CPF: ");
        String nome = JOptionPane.showInputDialog("Insira o novo nome: ");
        String dtNasc = JOptionPane.showInputDialog("Insira a nova data de nascimento: ");
        int anoAdmissao = Integer.parseInt(JOptionPane.showInputDialog("Em qual ano este funcionário foi contratado?"));
        int idLoca = Integer.parseInt(JOptionPane.showInputDialog("Qual o id da locadora em que " +
                "esse funcionário trabalha?"));

        Funcionario funcionario = new Funcionario(id, cpf, nome, dtNasc, anoAdmissao);

        try {

            //Criando a conexão com o banco e o DAO do Fncionário e da Locadora para setar a FK
            Connection conn = ConnectionFactory.getConnection();
            FuncionarioDao daoFunc = new FuncionarioDao(conn);

            LocadoraDao locaDao = new LocadoraDao(conn);
            Locadora locadora = locaDao.pesquisaId(idLoca);
            funcionario.setLocadora(locadora);

            daoFunc.atualizar(funcionario);
            System.out.println("Funcionário atualizado com sucesso!");

        } catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
}
