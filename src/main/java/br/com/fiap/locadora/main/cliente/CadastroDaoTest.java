package br.com.fiap.locadora.main.cliente;

import br.com.fiap.locadora.connection.ConnectionFactory;
import br.com.fiap.locadora.dao.ClienteDao;
import br.com.fiap.locadora.model.Cliente;

import javax.swing.*;
import java.sql.Connection;

public class CadastroDaoTest {
    public static void main(String[] args) {

        //Pedir os dados de cadastro
        String cpf = JOptionPane.showInputDialog("Insira seu CPF: ");
        String nome = JOptionPane.showInputDialog("Insira seu nome: ");
        String dtNasc = JOptionPane.showInputDialog("Insira sua data de nascimento: ");
        String endereco = JOptionPane.showInputDialog("Insira seu endereço: ");
        String email = JOptionPane.showInputDialog("Insira seu Email: ");

        try {

            //Criando a conexão com o banco
            Connection con = ConnectionFactory.getConnection();

            ClienteDao dao = new ClienteDao(con);

            //Instanciando o cliente
            Cliente cliente = new Cliente(cpf, nome, dtNasc, endereco, email);

            dao.cadastrar(cliente);
            System.out.println("Cadastro realizado com sucesso!");

        } catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
}
