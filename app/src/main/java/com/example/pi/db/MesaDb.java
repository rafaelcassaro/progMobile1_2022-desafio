package com.example.pi.db;

import com.example.pi.models.Mesa;

import java.util.ArrayList;
import java.util.List;

public class MesaDb {

    public static List<Mesa> myDataset = new ArrayList<>();
    //public static Comanda cd = ComandaDb.comandaDataSet.get(0);

    static {
        myDataset.add(new Mesa(7, ComandaDb.comandaDataSet.get(0)));
        myDataset.add(new Mesa(2,ComandaDb.comandaDataSet.get(1)));
        myDataset.add(new Mesa(3,ComandaDb.comandaDataSet.get(2)));

        //myDataset.add(new Mesa(3,cd));
        //myDataset.add(new Mesa(3,cd));
        //myDataset.add(new Mesa(3,cd));

        //myDataset.add(new Mesa(7));
        //myDataset.add(new Mesa(2));
        //myDataset.add(new Mesa(3));


        /*myDataset.add(new Mesa());
        myDataset.add(new Mesa());
        myDataset.add(new Mesa());
        myDataset.add(new Mesa());
        myDataset.add(new Mesa());
        myDataset.add(new Mesa());
        myDataset.add(new Mesa());*/


    }
}
