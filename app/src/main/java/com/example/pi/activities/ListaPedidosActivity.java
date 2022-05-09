package com.example.pi.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.pi.R;
import com.example.pi.adapter.PedidoAdapter;
import com.example.pi.models.Pedido;
import com.example.pi.models.PedidoDb;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ListaPedidosActivity extends AppCompatActivity {

    public static final String EXTRA_SHOW = "EXTRA_SHOW";
    private RecyclerView recyclerView;
    private PedidoAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_pedidos);

        recyclerView = findViewById(R.id.main_recyclerView);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new PedidoAdapter(this, new PedidoAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Pedido pedido = PedidoDb.myDataset.get(position);
                Intent intent = new Intent(ListaPedidosActivity.this, DetalhesPedidosActivity.class);
                //intent.putExtra(EXTRA_SHOW, pedido);
                startActivity(intent);
            }
        });
        recyclerView.setAdapter(adapter);


        FloatingActionButton add_pedido = findViewById(R.id.add_pedido);
        add_pedido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ListaPedidosActivity.this, NovoPedidoActivity.class);
                startActivity(i);
            }
        });

    }

    private class ViewHolder{
        RecyclerView rv;
    }
}