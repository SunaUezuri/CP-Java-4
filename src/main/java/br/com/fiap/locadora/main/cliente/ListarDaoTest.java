package br.com.fiap.locadora.main.cliente;

import br.com.fiap.locadora.connection.ConnectionFactory;
import br.com.fiap.locadora.dao.ClienteDao;
import br.com.fiap.locadora.model.Cliente;

import java.sql.Connection;
import java.util.List;

public class ListarDaoTest {
    public static void main(String[] args) {

        try {

            //Criando a conexao com o banco de dados
            Connection conn = ConnectionFactory.getConnection();
            ClienteDao dao = new ClienteDao(conn);

            //Criando a lista de exibição
            List<Cliente> lista = dao.listar();

            //Exibir os dados encontrados
            for (Cliente c : lista){
                System.out.println(c + "\n");
            }

        } catch (Exception e){
            System.err.println(e.getMessage());
        }

    }
}
