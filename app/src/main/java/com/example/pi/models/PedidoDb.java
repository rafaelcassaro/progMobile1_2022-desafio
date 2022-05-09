package com.example.pi.models;

import java.util.ArrayList;
import java.util.List;

public class PedidoDb {
    public static List<Pedido> myDataset = new ArrayList<>();

    static {
        myDataset.add(new Pedido("prato 1", "bebida 1" , "1" , "1" , "1", "1"));
        myDataset.add(new Pedido("prato 2", "bebida 2" , "2" , "2" , "2", "2"));
        myDataset.add(new Pedido("prato 3", "bebida 3" , "3" , "3" , "3", "3"));
        myDataset.add(new Pedido("prato 4", "bebida 4" , "4" , "4" , "4", "4"));
        myDataset.add(new Pedido("prato 5", "bebida 5" , "5" , "5" , "5", "5"));
        myDataset.add(new Pedido("prato 6", "bebida 6" , "6" , "6" , "6", "6"));
        myDataset.add(new Pedido("prato 7", "bebida 7" , "6" , "6" , "6", "6"));
        myDataset.add(new Pedido("prato 8", "bebida 8" , "6" , "6" , "6", "6"));
        myDataset.add(new Pedido("prato 9", "bebida 9" , "6" , "6" , "6", "6"));
        myDataset.add(new Pedido("prato 10", "bebida 10" , "6" , "6" , "6", "6"));
    }
}
