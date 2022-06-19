package com.example.pi.models;

import java.util.ArrayList;
import java.util.List;

public class AlimentosDb {



    public static List<Alimento> myDataset = new ArrayList<>();

    static {
        myDataset.add(new Alimento("Prato 1", "xxxxxxxxxx xxxxxxx xxxxxxxxx", 3));
        myDataset.add(new Alimento("Prato 2", "xxxxxxxxxx xxxxxxx xxxxxxxxx", 2));
        myDataset.add(new Alimento("Prato 3", "xxxxxxxxxx xxxxxxx xxxxxxxxx", 1));
        myDataset.add(new Alimento("Prato 4", "xxxxxxxxxx xxxxxxx xxxxxxxxx", 1));
        myDataset.add(new Alimento("Prato 5", "xxxxxxxxxx xxxxxxx xxxxxxxxx", 2));
        myDataset.add(new Alimento("Prato 6", "xxxxxxxxxx xxxxxxx xxxxxxxxx", 3));
        myDataset.add(new Alimento("Prato 7", "xxxxxxxxxx xxxxxxx xxxxxxxxx", 4));

    }
}
