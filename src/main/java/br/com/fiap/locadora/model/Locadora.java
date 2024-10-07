package br.com.fiap.locadora.model;

public class Locadora {

    private int id;
    private String nome;
    private String endereco;
    private String telefone;



    //Método toString

    @Override
    public String toString() {
        return "ID: " + id +
                "\nNome: " + nome +
                "\nEndereço: " + endereco +
                "\nTelefone: " + telefone;
    }

    //Construtores da classe

    public Locadora(int id, String nome, String endereco, String telefone) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
    }

    public Locadora(String nome, String endereco, String telefone) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
    }

    public Locadora(String nome, String endereco) {
        this.nome = nome;
        this.endereco = endereco;
    }

    //Getters and Setters


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

}
