package com.example.pi.models;

import java.util.ArrayList;
import java.util.List;

public class CardapioDb {

    public static List<Cardapio> myDataset = new ArrayList<>();

    static {
        myDataset.add(new Cardapio("Prato 1" , "xxxxxxx xxxxxx xxxxxx"));
        myDataset.add(new Cardapio("Prato 2" , "xxxxxxx xxxxxx xxxxxx"));
        myDataset.add(new Cardapio("Prato 3" , "xxxxxxx xxxxxx xxxxxx"));

    }
}
