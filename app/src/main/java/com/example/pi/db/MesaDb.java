package com.example.pi.db;

import com.example.pi.models.Mesa;

import java.util.ArrayList;
import java.util.List;

public class MesaDb {

    public static List<Mesa> myDataset = new ArrayList<>();


    static {
        myDataset.add(new Mesa(7, ComandaDb.comandaDataSet.get(0)));
        myDataset.add(new Mesa(2,ComandaDb.comandaDataSet.get(1)));
        myDataset.add(new Mesa(3,ComandaDb.comandaDataSet.get(2)));

    }
}
