package com.example.pi.models;

import java.util.ArrayList;
import java.util.List;

public class ComandaDb {
    public static List<Comanda> comandaDataSet = new ArrayList<>();

    static{
        comandaDataSet.add(new Comanda("Jose",2, BebidaDb.myDataset));
        comandaDataSet.add(new Comanda("adailto",1, BebidaDb.myDataset));
        comandaDataSet.add(new Comanda("Jose",1, BebidaDb.myDataset));
    }
    //public static Comanda comandaDataSet = new Comanda("Jose",2,BebidaDb.myDataset);


}
