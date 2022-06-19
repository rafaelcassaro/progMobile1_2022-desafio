package com.example.pi.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Mesa implements Serializable {
    private Integer numMesa;
    private Comanda comanda;

    public Integer getNumMesa() {
        return numMesa;
    }
    public void setNumMesa(Integer numMesa) {
        this.numMesa = numMesa;
    }
    public Comanda getComanda() {
        return comanda;
    }
    public void setComanda(Comanda comanda) {
        this.comanda = comanda;
    }

    public Mesa(){}

    public Mesa(Integer numMesa) {
        this.numMesa = numMesa;
    }


    public Mesa(Integer numMesa, Comanda comanda) {
        this.numMesa = numMesa;
        this.comanda = comanda;
    }

    @Override
    public String toString() {
        return "Mesa [numMesa=" + numMesa + ", comanda=" + comanda + "]";
    }

    public String getNomeGarcom() {
        return comanda.getNomeGarcom();
    }

    public Integer getNumComanda() {
        return comanda.getNumComanda();
    }

    public List<Alimento>  getListAlimentos() {
        return comanda.getAlimentos();
    }
}
