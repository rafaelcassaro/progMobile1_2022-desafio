package com.example.pi.models;

import java.io.Serializable;

public class Cardapio implements Serializable {
    private String titulo;
    private String detalhe;

    public Cardapio(String titulo, String detalhe) {
        this.titulo = titulo;
        this.detalhe = detalhe;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDetalhe() {
        return detalhe;
    }

    public void setDetalhe(String detalhe) {
        this.detalhe = detalhe;
    }

    @Override
    public String toString() {
        return "Cardapio{" +
                "titulo='" + titulo + '\'' +
                ", detalhe='" + detalhe + '\'' +
                '}';
    }
}
