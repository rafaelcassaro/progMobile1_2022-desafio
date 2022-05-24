package com.example.pi.models;

import java.util.ArrayList;
import java.util.List;

public class CardapioDb {

    public static List<Cardapio> myDataset = new ArrayList<>();

    static {
        myDataset.add(new Cardapio("Prato 1" , "xxxxxxx xxxxxx xxxxxx" , "bebida 1",0,1));
        myDataset.add(new Cardapio("Prato 2" , "xxxxxxx xxxxxx xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx","bebida 2", 0,0));
        myDataset.add(new Cardapio("Prato 3" , "xxxxxxx xxxxxx xxxxxx","bebida 3", 1,2));
        myDataset.add(new Cardapio("Prato 1" , "xxxxxxx xxxxxx xxxxxx","bebida 4", 2,3));
        myDataset.add(new Cardapio("Prato 2" , "xxxxxxx xxxxxx xxxxxx","bebida 5", 3,4));
        myDataset.add(new Cardapio("Prato 3" , "xxxxxxx xxxxxx xxxxxx","bebida 6", 3,5));
        myDataset.add(new Cardapio("Prato 1" , "xxxxxxx xxxxxx xxxxxx","bebida 7", 4,6));
        myDataset.add(new Cardapio("Prato 2" , "xxxxxxx xxxxxx xxxxxx","bebida 8", 5,7));
        myDataset.add(new Cardapio("Prato 3" , "xxxxxxx xxxxxx xxxxxx","bebida 9", 6,8));



    }
}

