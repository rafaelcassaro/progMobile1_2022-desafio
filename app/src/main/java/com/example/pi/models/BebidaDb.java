package com.example.pi.models;

import java.util.ArrayList;
import java.util.List;

public class BebidaDb {

    public static List<Alimento> myDataset = new ArrayList<>();

    static {
        myDataset.add(new Alimento("Bebida1", 3));
        myDataset.add(new Alimento("Bebida2", 2));
        myDataset.add(new Alimento("Bebida3", 1));
        myDataset.add(new Alimento("Bebida4", 0));
        myDataset.add(new Alimento("Bebida5", 1));
        myDataset.add(new Alimento("Bebida6", 1));

    }
}
