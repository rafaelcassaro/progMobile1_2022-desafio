package com.example.pi.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.pi.R;
import com.example.pi.db.MesaDb;
import com.example.pi.models.Mesa;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DetalhesPedidosActivity extends AppCompatActivity {

    public static final String EXTRA_NEW_CONTACTT = "EXTRA_NEW_CONTACTT";
    private TextView alimentosTv;
    private TextView nomeTv;
    private TextView mesaTv;
    private TextView comandaTv;
    private TextView totalTv;
    private TextView dataTv;
    private Button  del_bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes_pedidos);

        SimpleDateFormat sdf = new SimpleDateFormat("ddMMHHmmssmm");
        alimentosTv = findViewById(R.id.prods_detalhe_tv);
        nomeTv = findViewById(R.id.nome_detalhe_tv);
        mesaTv = findViewById(R.id.mesa_detalhe_tv);
        comandaTv = findViewById(R.id.comanda_detalhe_tv);
        totalTv = findViewById(R.id.total_detalhe_tv);
        dataTv = findViewById(R.id.data_detalhe_tv);
        del_bt = findViewById(R.id.delete_pedido_bt);

        Intent intent = getIntent();
        Mesa mesa = (Mesa) intent.getSerializableExtra(ListaPedidosActivity.EXTRA_SHOW);
        DecimalFormat deci = new DecimalFormat("00.00");

        alimentosTv.setText(mesa.getComanda().printAlimentos());
        dataTv.setText(mesa.getComanda().dataDetalhes());
        nomeTv.setText(mesa.getNomeGarcom());
        comandaTv.setText(String.valueOf(mesa.getNumComanda()));
        mesaTv.setText(String.valueOf(mesa.getNumMesa()));
        //totalTv.setText(String.valueOf(mesa.getTotal()));
        totalTv.setText(deci.format(mesa.getTotal()));


        Date dateTeste = mesa.getComanda().getMoment();
        long dateThis = Long.parseLong(sdf.format(dateTeste));

        del_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                for(int a = 0;  a < MesaDb.myDataset.size() ; a++){
                    Date dateDbTeste = MesaDb.myDataset.get(a).getComanda().getMoment();
                    long dateDbThis = Long.parseLong(sdf.format(dateDbTeste));

                    if( dateDbThis == dateThis){
                        MesaDb.myDataset.remove(a);
                        Intent i = new Intent();
                        //Intent i = new Intent(DetalhesPedidosActivity.this, ListaPedidosActivity.class);
                        //startActivity(i);
                        setResult(RESULT_OK, i);
                        finish();
                    }
                }


            }
        });

    }
}