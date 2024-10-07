package br.com.fiap.locadora.model;

import java.sql.Date;

public class Cliente extends Pessoa{

    private String endereco;
    private String email;

    //Método toString
    @Override
    public String toString() {
        return super.toString() +
                "\nEndereço: " + endereco +
                "\nEmail: " + email;
    }

    //Construtores

    public Cliente(int id, String cpf, String nome, String dtNasc, String endereco, String email) {
        super(id, cpf, nome, dtNasc);
        this.endereco = endereco;
        this.email = email;
    }

    public Cliente(String cpf, String nome, String dtNasc, String endereco, String email) {
        super(cpf, nome, dtNasc);
        this.endereco = endereco;
        this.email = email;
    }

    //Getters and Setters


    public String getEndereco() {
        return endereco;
    }

    public String getEmail() {
        return email;
    }
}
