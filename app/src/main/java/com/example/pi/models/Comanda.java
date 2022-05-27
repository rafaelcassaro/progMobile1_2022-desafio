package com.example.pi.models;

import java.util.ArrayList;
import java.util.List;

public class Comanda {
    private String nomeGarcom;
    private List<Alimento> alimentos = new ArrayList<>();

    public Comanda() {
    }

    public Comanda(String nomeGarcom, List<Alimento> alimentos) {
        this.nomeGarcom = nomeGarcom;
        this.alimentos = alimentos;
    }

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


}