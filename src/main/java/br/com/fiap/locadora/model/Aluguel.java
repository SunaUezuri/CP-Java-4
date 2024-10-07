package br.com.fiap.locadora.model;

public class Aluguel {

    private int id;
    private String dtAluguel;
    private String dtDevolucao;

    //Foreing Keys
    private Filme filme;
    private Cliente cliente;

    //Método toString
    @Override
    public String toString() {
        return "ID: " + id +
                "\nData em que foi alugado: " + dtAluguel +
                "\nData de devolução: " + dtDevolucao;
    }

    //Construtores

    public Aluguel(int id, String dtAluguel, String dtDevolucao) {
        this.id = id;
        this.dtAluguel = dtAluguel;
        this.dtDevolucao = dtDevolucao;
    }

    public Aluguel(String dtAluguel, String dtDevolucao) {
        this.dtAluguel = dtAluguel;
        this.dtDevolucao = dtDevolucao;
    }

    //Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDtAluguel() {
        return dtAluguel;
    }

    public void setDtAluguel(String dtAluguel) {
        this.dtAluguel = dtAluguel;
    }

    public String getDtDevolucao() {
        return dtDevolucao;
    }

    public void setDtDevolucao(String dtDevolucao) {
        this.dtDevolucao = dtDevolucao;
    }

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
