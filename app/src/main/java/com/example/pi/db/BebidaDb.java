package com.example.pi.db;

import com.example.pi.models.Alimento;

import java.util.ArrayList;
import java.util.List;

public class BebidaDb {

    public static List<Alimento> myDataset = new ArrayList<>();

    static {
        myDataset.add(new Alimento("Bebida1", 3,1.01));
        myDataset.add(new Alimento("Bebida2", 0,2.01));
        myDataset.add(new Alimento("Bebida3", 0,3.01));
        myDataset.add(new Alimento("Bebida4", 0,4.01));
        myDataset.add(new Alimento("Bebida5", 2,5.01));
        myDataset.add(new Alimento("Bebida6", 4,6.01));

    }
}
