package br.com.fiap.locadora.model;

public abstract class Pessoa {

    private int id;
    private String cpf;
    private String nome;
    private String dtNasc;

    //Método toString
    @Override
    public String toString() {
        return "ID: " + id +
                "\nCPF: " + cpf +
                "\nNome: " + nome +
                "\nData de nascimento: " + dtNasc;
    }

    //Constructors

    public Pessoa(int id, String cpf, String nome, String dtNasc) {
        this.id = id;
        this.cpf = cpf;
        this.nome = nome;
        this.dtNasc = dtNasc;
    }

    public Pessoa(String cpf, String nome, String dtNasc) {
        this.cpf = cpf;
        this.nome = nome;
        this.dtNasc = dtNasc;
    }

    //Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDtNasc() {
        return dtNasc;
    }

    public void setDtNasc(String dtNasc) {
        this.dtNasc = dtNasc;
    }
}
