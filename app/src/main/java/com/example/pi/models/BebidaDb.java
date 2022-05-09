package com.example.pi.models;

import java.util.ArrayList;
import java.util.List;

public class BebidaDb {
    public static List<Bebida> myDataset = new ArrayList<>();

    static {
        myDataset.add(new Bebida("Bebida 1"));
        myDataset.add(new Bebida("Bebida 2"));
        myDataset.add(new Bebida("Bebida 3"));
    }
}
