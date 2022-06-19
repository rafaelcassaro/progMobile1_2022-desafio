package com.example.pi.models;

import java.util.ArrayList;
import java.util.List;

public class AlimentosDb {



    public static List<Alimento> myDataset = new ArrayList<>();

    static {
        myDataset.add(new Alimento("Prato 1", "xxxxxxxxxx xxxxxxx xxxxxxxxx", 0,11.01));
        myDataset.add(new Alimento("Prato 2", "xxxxxxxxxx xxxxxxx xxxxxxxxx", 0,12.01));
        myDataset.add(new Alimento("Prato 3", "xxxxxxxxxx xxxxxxx xxxxxxxxx", 0,13.01));
        myDataset.add(new Alimento("Prato 4", "xxxxxxxxxx xxxxxxx xxxxxxxxx", 0,14.01));
        myDataset.add(new Alimento("Prato 5", "xxxxxxxxxx xxxxxxx xxxxxxxxx", 0,15.01));
        myDataset.add(new Alimento("Prato 6", "xxxxxxxxxx xxxxxxx xxxxxxxxx", 0,16.01));
        myDataset.add(new Alimento("Prato 7", "xxxxxxxxxx xxxxxxx xxxxxxxxx", 0,17.01));

    }
}
