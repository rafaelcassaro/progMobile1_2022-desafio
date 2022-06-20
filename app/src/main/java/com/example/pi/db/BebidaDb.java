package com.example.pi.db;

import com.example.pi.models.Alimento;

import java.util.ArrayList;
import java.util.List;

public class BebidaDb {

    public static List<Alimento> myDataset = new ArrayList<>();

    static {
        myDataset.add(new Alimento("COCA", 0,7.00));
        myDataset.add(new Alimento("PEPSI", 0,6.5));
        myDataset.add(new Alimento("FANTA UVA", 0,6.00));
        myDataset.add(new Alimento("SKOL", 0,2.20));
        myDataset.add(new Alimento("HEINEKEN", 0,3.50));
        myDataset.add(new Alimento("GLACIAL", 0,2.00));

    }
}
