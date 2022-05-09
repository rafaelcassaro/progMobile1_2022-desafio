package com.example.pi.models;

import java.io.Serializable;

public class Bebida implements Serializable {
    private String bebida;

    public Bebida(String bebida) {
        this.bebida = bebida;
    }

    public String getBebida() {
        return bebida;
    }

    public void setBebida(String bebida) {
        this.bebida = bebida;
    }
}
