package com.example.pi.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.pi.R;
import com.example.pi.models.Mesa;

public class DetalhesPedidosActivity extends AppCompatActivity {

    /*
    private RecyclerView recyclerView;
    private DetalhesPedidosAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;*/

    private TextView alimentosTv;
    private TextView nomeTv;
    private TextView mesaTv;
    private TextView comandaTv;
    private TextView totalTv;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes_pedidos);

        alimentosTv = findViewById(R.id.prods_detalhe_tv);
        nomeTv = findViewById(R.id.nome_detalhe_tv);
        mesaTv = findViewById(R.id.mesa_detalhe_tv);
        comandaTv = findViewById(R.id.comanda_detalhe_tv);
        totalTv = findViewById(R.id.total_detalhe_tv);

        Intent intent = getIntent();
        Mesa mesa = (Mesa) intent.getSerializableExtra(ListaPedidosActivity.EXTRA_SHOW);

        alimentosTv.setText(String.valueOf(mesa.getListAlimentos()));
        nomeTv.setText(mesa.getNomeGarcom());
        comandaTv.setText(String.valueOf(mesa.getNumComanda()));
        mesaTv.setText(String.valueOf(mesa.getNumMesa()));









        /*
        recyclerView = findViewById(R.id.detalhes_rv);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        Intent intent = getIntent();
        Mesa mesa = (Mesa) intent.getSerializableExtra(ListaPedidosActivity.EXTRA_SHOW);

        adapter = new DetalhesPedidosAdapter(this, mesa);


        recyclerView.setAdapter(adapter);*/

    }
}