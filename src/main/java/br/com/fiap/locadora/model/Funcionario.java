package br.com.fiap.locadora.model;

public class Funcionario extends Pessoa{

    private int anoAdmissao;

    //Foreing Key
    private Locadora locadora;

    //Método toString
    @Override
    public String toString() {
        return super.toString() +
                "\nData de Admissão: " + anoAdmissao;
    }

    //Construtores

    public Funcionario(int id, String cpf, String nome, String dtNasc, int anoAdmissao) {
        super(id, cpf, nome, dtNasc);
        this.anoAdmissao = anoAdmissao;
    }

    public Funcionario(String cpf, String nome, String dtNasc, int anoAdmissao) {
        super(cpf, nome, dtNasc);
        this.anoAdmissao = anoAdmissao;
    }

    //Getters and Setters


    public int getAnoAdmissao() {
        return anoAdmissao;
    }

    public void setAnoAdmissao(int anoAdmissao) {
        this.anoAdmissao = anoAdmissao;
    }

    public Locadora getLocadora() {
        return locadora;
    }

    public void setLocadora(Locadora locadora) {
        this.locadora = locadora;
    }
}
