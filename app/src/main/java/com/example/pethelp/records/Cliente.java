package com.example.pethelp.records;

public class Cliente {

    private String nome;
    private String CPF;
    private String RG;
    private String senha;
    private String email;
    private boolean notificacao;
    private String endereco;


    public Cliente(String nome, String CPF, String RG, String senha,
                   String email, boolean notificacao, String endereco) {
        this.nome = nome;
        this.CPF = CPF;
        this.RG = RG;
        this.senha = senha;
        this.email = email;
        this.notificacao = notificacao;
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public String getCPF() {
        return CPF;
    }

    public String getRG() {
        return RG;
    }

    public String getSenha() {
        return senha;
    }

    public String getEmail() {
        return email;
    }

    public boolean isNotificacao() {
        return notificacao;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setNotificacao(boolean notificacao) {
        this.notificacao = notificacao;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setRG(String RG) {
        this.RG = RG;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
