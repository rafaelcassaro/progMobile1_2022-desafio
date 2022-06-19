package com.example.pi.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Comanda implements Serializable {
    private String nomeGarcom;
    private Integer numComanda;
    private Date data;
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

    public void setAlimento(Alimento adicionar){
        this.alimentos.add(adicionar);
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

    public Double getTotal() {
        Double preco = 0.0;
        for(int i = 0; i < alimentos.size(); i++) {
            preco = (alimentos.get(i).getValor()*alimentos.get(i).getQntd()) + preco;
        }
        return preco;
    }


    @Override
    public String toString() {
        return "Comanda [nomeGarcom=" + nomeGarcom + ", numComanda=" + numComanda + ", alimentos=" + alimentos + "]";
    }
}
