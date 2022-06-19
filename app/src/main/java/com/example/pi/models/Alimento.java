package com.example.pi.models;

import java.io.Serializable;

public class Alimento implements Serializable {
    private String produto;
    private String detalhe;
    private Integer qntd;
    //private Double valor;

    public Alimento() {
    }

    public Alimento(String produto, String detalhe, Integer qntd) {
        this.produto = produto;
        this.detalhe = detalhe;
        this.qntd = qntd;
    }

    public Alimento(String produto, Integer qntd) {
        this.produto = produto;
        this.qntd = qntd;
    }

    @Override
    public String toString() {
        return  produto  +" x"+ qntd + "\n";
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public String getDetalhe() {
        return detalhe;
    }

    public void setDetalhe(String detalhe) {
        this.detalhe = detalhe;
    }

    public Integer getQntd() {
        return qntd;
    }

    public void setQntd(Integer qntd) {
        this.qntd = qntd;
    }


}
