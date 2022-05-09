package com.example.pi.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.pi.R;
import com.example.pi.adapter.BebidaAdapter;
import com.example.pi.adapter.CardapioAdapter;
import com.example.pi.adapter.PedidoAdapter;
import com.example.pi.models.Bebida;
import com.example.pi.models.BebidaDb;
import com.example.pi.models.Cardapio;
import com.example.pi.models.CardapioDb;

public class NovoPedidoActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    CardapioAdapter adapter;
    RecyclerView.LayoutManager layoutManager;
    //----------------
    RecyclerView recyclerViewB;
    BebidaAdapter adapterB;
    RecyclerView.LayoutManager layoutManagerB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novo_pedido);

        recyclerView = findViewById(R.id.cardapio_rv);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        //---------------------
        recyclerViewB = findViewById(R.id.bebida_rv);
        recyclerViewB.setHasFixedSize(true);
        layoutManagerB = new LinearLayoutManager(this);


        adapter = new CardapioAdapter(this, new PedidoAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Cardapio cardapio = CardapioDb.myDataset.get(position);
                Toast.makeText(NovoPedidoActivity.this, cardapio.toString(), Toast.LENGTH_SHORT).show();
            }
        });
        //-------------
        adapterB = new BebidaAdapter(this, new BebidaAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Bebida bb = BebidaDb.myDataset.get(position);
                Toast.makeText(NovoPedidoActivity.this, bb.toString(), Toast.LENGTH_SHORT).show();
            }
        });


        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        //-------------------
        recyclerViewB.setLayoutManager(layoutManagerB);
        recyclerViewB.setAdapter(adapterB);

    }
}