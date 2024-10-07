package br.com.fiap.locadora.main.locadora;

import br.com.fiap.locadora.connection.ConnectionFactory;
import br.com.fiap.locadora.dao.LocadoraDao;
import br.com.fiap.locadora.model.Locadora;

import javax.swing.*;
import java.sql.Connection;

public class CadastroDaoTest {
    public static void main(String[] args) {

        //Pedir os dados da locadora
        String nome = JOptionPane.showInputDialog("Insira o nome da locadora que será registrada: ");
        String endereco = JOptionPane.showInputDialog("Insira o endereço da locadora: ");

        boolean adicionarTelefone = JOptionPane.showConfirmDialog(null,
                "Deseja adicionar um número de telefone?") == 0;

        try {

            //Criando a conexão com o banco de dados e o DAO da Locadora
            Connection conn = ConnectionFactory.getConnection();
            LocadoraDao dao = new LocadoraDao(conn);

            //Instanciando a locadora
            Locadora locadora = new Locadora(nome, endereco);

            if (adicionarTelefone){
                String telefone = JOptionPane.showInputDialog("Insira o número de telefone: ");
                locadora.setTelefone(telefone);
            }

            dao.cadastrar(locadora);
            System.out.println("Locadora cadastrada com sucesso");

        } catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
}
