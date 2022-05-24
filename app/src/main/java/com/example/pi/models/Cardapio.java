package com.example.pi.models;

import java.io.Serializable;

public class Cardapio implements Serializable {
    private String titulo;
    private String detalhe;
    private String bebida;
    private Integer qntd;
    private Integer qntdBebida;


    public Cardapio(){}

    public Cardapio(String titulo, String detalhe, String bebida, Integer qntd, Integer qntdBebida) {
        this.titulo = titulo;
        this.detalhe = detalhe;
        this.bebida = bebida;
        this.qntd = qntd;
        this.qntdBebida = qntdBebida;
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

    public String getBebida() {
        return bebida;
    }

    public void setBebida(String bebida) {
        this.bebida = bebida;
    }

    public Integer getQntd() {
        return qntd;
    }

    public void setQntd(Integer qntd) {
        this.qntd = qntd;
    }

    public Integer getQntdBebida() {
        return qntdBebida;
    }

    public void setQntdBebida(Integer qntdBebida) {
        this.qntdBebida = qntdBebida;
    }
}
