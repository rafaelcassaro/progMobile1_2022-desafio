package com.example.pi.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Comanda implements Serializable {
    private String nomeGarcom;
    private Integer numComanda;
    private List<Alimento> alimentos;

    public String getNomeGarcom() {
        return nomeGarcom;
    }
    public void setNomeGarcom(String nomeGarcom) {
        this.nomeGarcom = nomeGarcom;
    }
    public List<Alimento> getAlimentos() {
        return alimentos;
    }
    public void setAlimentos(List<Alimento> alimentos) {
        this.alimentos = alimentos;
    }
    public Integer getNumComanda() {
        return numComanda;
    }
    public void setNumComanda(Integer numComanda) {
        this.numComanda = numComanda;
    }


    public Comanda(String nomeGarcom, Integer numComanda) {
        this.nomeGarcom = nomeGarcom;
        this.numComanda = numComanda;
        this.alimentos = new ArrayList<Alimento>();
    }
    public Comanda(String nomeGarcom, Integer numComanda, List<Alimento> alimentos) {
        this.nomeGarcom = nomeGarcom;
        this.numComanda = numComanda;
        this.alimentos = new ArrayList<Alimento>();
        this.alimentos = alimentos;
    }


    @Override
    public String toString() {
        return "Comanda [nomeGarcom=" + nomeGarcom + ", numComanda=" + numComanda + ", alimentos=" + alimentos + "]";
    }
}
