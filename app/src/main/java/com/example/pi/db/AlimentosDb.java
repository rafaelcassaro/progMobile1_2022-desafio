package com.example.pi.db;

import com.example.pi.models.Alimento;

import java.util.ArrayList;
import java.util.List;

public class AlimentosDb {


    public static List<Alimento> myDataset = new ArrayList<>();

    static {
        myDataset.add(new Alimento("PRATO A", "xxxxxxxxxx xxxxxxx xxxxxxxxx", 0,25.00));
        myDataset.add(new Alimento("PRATO B", "xxxxxxxxxx xxxxxxx xxxxxxxxx", 0,30.50));
        myDataset.add(new Alimento("PRATO C", "xxxxxxxxxx xxxxxxx xxxxxxxxx", 0,22.50));
        myDataset.add(new Alimento("PRATO D", "xxxxxxxxxx xxxxxxx xxxxxxxxx", 0,15.01));
        myDataset.add(new Alimento("PRATO E", "xxxxxxxxxx xxxxxxx xxxxxxxxx", 0,7.01));
        myDataset.add(new Alimento("PRATO F", "xxxxxxxxxx xxxxxxx xxxxxxxxx", 0,9.00));
        myDataset.add(new Alimento("PRATO G", "xxxxxxxxxx xxxxxxx xxxxxxxxx", 0,26.00));


    }
}
