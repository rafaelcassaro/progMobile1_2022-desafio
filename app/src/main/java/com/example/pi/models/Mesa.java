package com.example.pi.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Mesa implements Serializable {
    private List<Comanda> comandas = new ArrayList<>();

    public Mesa() {
    }


    public Mesa(List<Comanda> comandas) {
        this.comandas = comandas;
    }

    public List<Comanda> getComandas() {
        return comandas;
    }

    public void setComandas(List<Comanda> comandas) {
        this.comandas = comandas;
    }
}
