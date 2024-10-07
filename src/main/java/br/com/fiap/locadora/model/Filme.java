package br.com.fiap.locadora.model;

public class Filme {

    private int id;
    private String nome;
    private String diretor;
    private int anoLancamento;
    private String genero;
    private String sinopse;
    private int duracao;            //Em minutos
    private String classificacao;

    //Foreing Key
    private Locadora locadora;

    //Método toString

    @Override
    public String toString() {
        return "ID: " + id +
                "\nNome: " + nome +
                "\nDiretor: " + diretor +
                "\nAno de Lançamento: " + anoLancamento +
                "\nGênero: " + genero +
                "\nSinopse: " + sinopse +
                "\nDuração: " + duracao +
                "\nClassificação: " + classificacao;
    }

    //Construtores


    public Filme(int id, String nome, String diretor, int anoLancamento,
                 String genero, String sinopse, int duracao, String classificacao) {
        this.id = id;
        this.nome = nome;
        this.diretor = diretor;
        this.anoLancamento = anoLancamento;
        this.genero = genero;
        this.sinopse = sinopse;
        this.duracao = duracao;
        this.classificacao = classificacao;
    }

    public Filme(String nome, String diretor, int anoLancamento, String genero,
                 String sinopse, int duracao, String classificacao) {
        this.nome = nome;
        this.diretor = diretor;
        this.anoLancamento = anoLancamento;
        this.genero = genero;
        this.sinopse = sinopse;
        this.duracao = duracao;
        this.classificacao = classificacao;
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

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    public int getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(int anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public String getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(String classificacao) {
        this.classificacao = classificacao;
    }

    public Locadora getLocadora() {
        return locadora;
    }

    public void setLocadora(Locadora locadora) {
        this.locadora = locadora;
    }
}
