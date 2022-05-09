package com.example.pi.models;

import java.io.Serializable;

public class Pedido implements Serializable {
    private String prato;
    private String bebida;
    private String qntPrato;
    private String qntBebida;
    private String mesa;
    private String pedido;

    public Pedido(String prato, String bebida, String qntPrato, String qntBebida, String mesa, String pedido) {
        this.prato = prato;
        this.bebida = bebida;
        this.qntPrato = qntPrato;
        this.qntBebida = qntBebida;
        this.mesa = mesa;
        this.pedido = pedido;
    }

    public String getPrato() {
        return prato;
    }

    public void setPrato(String prato) {
        this.prato = prato;
    }

    public String getBebida() {
        return bebida;
    }

    public void setBebida(String bebida) {
        this.bebida = bebida;
    }

    public String getQntPrato() {
        return qntPrato;
    }

    public void setQntPrato(String qntPrato) {
        this.qntPrato = qntPrato;
    }

    public String getQntBebida() {
        return qntBebida;
    }

    public void setQntBebida(String qntBebida) {
        this.qntBebida = qntBebida;
    }

    public String getMesa() {
        return mesa;
    }

    public void setMesa(String mesa) {
        this.mesa = mesa;
    }

    public String getPedido() {
        return pedido;
    }

    public void setPedido(String pedido) {
        this.pedido = pedido;
    }
}
