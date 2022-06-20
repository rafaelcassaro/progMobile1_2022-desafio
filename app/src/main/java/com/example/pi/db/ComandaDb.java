package com.example.pi.db;

import com.example.pi.models.Comanda;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ComandaDb {
    public static List<Comanda> comandaDataSet = new ArrayList<>();
    static SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    static Date fff, fff2, fff3;

    static{
        try {
            fff = formatter.parse("21/06/2018 13:05:44");
            fff2 = formatter.parse("21/06/2018 13:05:45");
            fff3 = formatter.parse("21/06/2018 13:05:46");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        comandaDataSet.add(new Comanda(fff,"Jose",2, BebidaDb.myDataset));
        comandaDataSet.add(new Comanda(fff2,"adailto",1, BebidaDb.myDataset));
        comandaDataSet.add(new Comanda(fff3,"Jose",1, BebidaDb.myDataset));



    }





}
