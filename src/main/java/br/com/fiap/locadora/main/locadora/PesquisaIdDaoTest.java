package br.com.fiap.locadora.main.locadora;

import br.com.fiap.locadora.connection.ConnectionFactory;
import br.com.fiap.locadora.dao.LocadoraDao;
import br.com.fiap.locadora.model.Locadora;

import javax.swing.*;
import java.sql.Connection;

public class PesquisaIdDaoTest {
    public static void main(String[] args) {

        //Pedindo o id para o usuário
        int id = Integer.parseInt(JOptionPane.showInputDialog("Insira o ID da locadora: "));

        try {

            //Criando a conexão com o banco e o DAO da locadora
            Connection conn = ConnectionFactory.getConnection();
            LocadoraDao dao = new LocadoraDao(conn);

            Locadora locadora = dao.pesquisaId(id);

            //Exibindo os dados pesquisados
            System.out.println(locadora);

        } catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
}
