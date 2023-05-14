package com.example.pethelp.records;

import java.sql.Date;

public class Adocao {

    private Date data;
    private String CPFCliente;
    private String CPFFuncionario;
    private String observacoes;
    private String codigo;
    private String codigoAnimal;

    public Adocao(Date data,String CPFCliente,String CPFFuncionario,
                  String observacoes,String codigo,String codigoAnimal) {
        this.data = data;
        this.CPFCliente = CPFCliente;
        this.CPFFuncionario = CPFFuncionario;
        this.observacoes = observacoes;
        this.codigo = codigo;
        this.codigoAnimal = codigoAnimal;
    }

    public String getCodigoAnimal() {
        return codigoAnimal;
    }

    public void setCodigoAnimal(String codigoAnimal) {
        this.codigoAnimal = codigoAnimal;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public String getCPFFuncionario() {
        return CPFFuncionario;
    }

    public void setCPFFuncionario(String CPFFuncionario) {
        this.CPFFuncionario = CPFFuncionario;
    }

    public String getCPFCliente() {
        return CPFCliente;
    }

    public void setCPFCliente(String CPFCliente) {
        this.CPFCliente = CPFCliente;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
}
