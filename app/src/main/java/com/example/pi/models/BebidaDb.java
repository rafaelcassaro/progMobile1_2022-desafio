package com.example.pi.models;

import java.util.ArrayList;
import java.util.List;

public class BebidaDb {

    public static List<Alimento> myDataset = new ArrayList<>();

    static {
        myDataset.add(new Alimento("Bebida1", 0));
        myDataset.add(new Alimento("Bebida2", 0));
        myDataset.add(new Alimento("Bebida3", 0));
        myDataset.add(new Alimento("Bebida4", 0));
        myDataset.add(new Alimento("Bebida5", 0));
        myDataset.add(new Alimento("Bebida6", 0));
        myDataset.add(new Alimento("Bebida7", 0));


    }
}
