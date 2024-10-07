package br.com.fiap.locadora.main.locadora;

import br.com.fiap.locadora.connection.ConnectionFactory;
import br.com.fiap.locadora.dao.LocadoraDao;
import br.com.fiap.locadora.model.Locadora;

import java.sql.Connection;
import java.util.List;

public class PesquisaDaoTest {
    public static void main(String[] args) {

        try {

            //Criando a conexão com o banco de dados e o DAO
            Connection conn = ConnectionFactory.getConnection();
            LocadoraDao dao = new LocadoraDao(conn);

            //Criando a lista para exibir os valores
            List<Locadora> lista = dao.pesquisar();

            for (Locadora l : lista){
                System.out.println(l + "\n");
            }
            System.out.println("\nLocadoras encontradas: " + lista.size());

        } catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
}
