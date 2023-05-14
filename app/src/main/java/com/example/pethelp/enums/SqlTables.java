package com.example.pethelp.enums;

public enum SqlTables {

    ADOCAO("adocao"),
    CLIENTE("cliente"),
    FUNCIONARIO("funcionario"),
    ANIMAL("animal"),
    LISTA("lista_de_animais_de_interesse"),
    CHAT("chat");

    private String nome;

    SqlTables(String nome) {
        this. nome = nome;
    }

    public String getNome() {
        return nome;
    }
}
