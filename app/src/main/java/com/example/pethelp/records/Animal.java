package com.example.pethelp.records;

public class Animal {

    private String raca;
    private String cor;
    private String genero;
    private String temperamento;
    private String foto;
    private boolean castrado;
    private String codigo;

    public Animal(String codigo, String raca, String cor, String genero,
                String temperamento, String foto, boolean castrado){
        this.raca = raca;
        this.cor = cor;
        this.genero = genero;
        this.temperamento = temperamento;
        this.foto = foto;
        this.castrado = castrado;
        this.codigo = codigo;

    }

    public boolean isCastrado() {
        return castrado;
    }

    public String getFoto() {
        return foto;
    }

    public String getTemperamento() {
        return temperamento;
    }

    public String getGenero() {
        return genero;
    }

    public String getCor() {
        return cor;
    }

    public String getRaca() {
        return raca;
    }

    public void setCastrado(boolean castrado) {
        this.castrado = castrado;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public void setTemperamento(String temperamento) {
        this.temperamento = temperamento;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}
