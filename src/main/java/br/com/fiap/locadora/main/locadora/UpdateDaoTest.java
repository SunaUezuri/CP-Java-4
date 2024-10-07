package br.com.fiap.locadora.main.locadora;

import br.com.fiap.locadora.connection.ConnectionFactory;
import br.com.fiap.locadora.dao.LocadoraDao;
import br.com.fiap.locadora.model.Locadora;

import javax.swing.*;
import java.sql.Connection;

public class UpdateDaoTest {
    public static void main(String[] args) {

        //Pedindo o id e os dados a serem modificados para o usuário
        int id = Integer.parseInt(JOptionPane.showInputDialog("Insira o ID da locadora cujo você quer modificar"));
        String nome = JOptionPane.showInputDialog("Insira o novo nome");
        String endereco = JOptionPane.showInputDialog("Insira o novo endereço");
        String telefone = JOptionPane.showInputDialog("Insira o novo telefone(Não obrigatório)");

        try {

            //Criando a conexão e o DAO
            Connection conn = ConnectionFactory.getConnection();
            LocadoraDao dao = new LocadoraDao(conn);

            //Instanciando a locadora
            Locadora locadora = new Locadora(id, nome, endereco, telefone);

            dao.atualizar(locadora);
            System.out.println("Locadora atualizada com sucesso!");

        } catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
}
