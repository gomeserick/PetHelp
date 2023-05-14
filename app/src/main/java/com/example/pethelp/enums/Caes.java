package com.example.pethelp.enums;

import com.example.pethelp.R;

import java.io.Serializable;

public enum Caes implements Serializable {

    CACHORRO1(R.id.Cachorro1,"teste1","Preto, Branco e Marrom",
            "Macho","Calmo",true, R.drawable.cachorro1),
    CACHORRO2(R.id.Cachorro2,"teste2","Dourado","Macho",
            "Brincalhão",false, R.drawable.cachorro2),
    CACHORRO3(R.id.Cachorro3,"Pitbull","Dourado","Femea",
            "Agressivo",true, R.drawable.cachorro3),
    CACHORRO4(R.id.Cachorro4,"Golden Retriever","Dourado",
            "Femea","Alegre",true, R.drawable.cachorro4);



    private int cachorro, imagem;
    private String raca,cor,genero,temperamento;
    private boolean castrado;



    Caes(int cachorro, String raca, String cor, String genero,
         String temperamento, boolean castrado, int image) {
        this.cachorro = cachorro;
        this.raca = raca;
        this.cor = cor;
        this.genero = genero;
        this.temperamento = temperamento;
        this.castrado = castrado;
        this.imagem = image;
    }

    public int getCachorro() {
        return cachorro;
    }

    public String getRaca() {
        return raca;
    }

    public String getCor() {
        return cor;
    }

    public String getGenero() {
        return genero;
    }

    public String getTemperamento() {
        return temperamento;
    }

    public boolean isCastrado() {
        return castrado;
    }

    public int getImagem() {
        return imagem;
    }
}
