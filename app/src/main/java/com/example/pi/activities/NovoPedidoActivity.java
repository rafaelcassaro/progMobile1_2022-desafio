package com.example.pi.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pi.R;
import com.example.pi.adapter.NovaBebidaAdapter;
import com.example.pi.adapter.NovoCardapioAdapter;
import com.example.pi.models.Cardapio;
import com.example.pi.models.CardapioDb;

public class NovoPedidoActivity extends AppCompatActivity {


    private String valorStr = "";
    private Integer qntdInt = 0;
    RecyclerView recyclerView;
    NovoCardapioAdapter adapter;
    RecyclerView.LayoutManager layoutManager;
    private ImageButton remove;
    private ImageButton add;
    private TextView qntItem;

    //----------------
    RecyclerView recyclerViewB;
    NovaBebidaAdapter adapterB;
    RecyclerView.LayoutManager layoutManagerB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novo_pedido);

        recyclerView = findViewById(R.id.cardapio_rv);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        ImageButton add =findViewById(R.id.add_item_bt);
        ImageButton remove = findViewById(R.id.remove_item_bt);
        qntItem = findViewById(R.id.qnt_bebida_tv);

        //---------------------
        recyclerViewB = findViewById(R.id.bebida_rv);
        recyclerViewB.setHasFixedSize(true);
        layoutManagerB = new LinearLayoutManager(this);



        /*
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                qntdInt = qntdInt +1;

                if(qntItem != null){
                    qntItem.setText(String.valueOf(qntdInt));
                }


            }
        });

        remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                qntdInt = qntdInt + 1;


                if(qntItem != null){
                    qntItem.setText(String.valueOf(qntdInt));
                }

            }
        });*/


        adapter = new NovoCardapioAdapter(this, new NovoCardapioAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                //Cardapio cardapio = CardapioDb.myDataset.get(position);
                //Toast.makeText(NovoPedidoActivity.this, cardapio.toString(), Toast.LENGTH_SHORT).show();
            }
        });
        //-------------

        adapterB = new NovaBebidaAdapter(this, new CardapioDb());

        /*adapterB = new NovaBebidaAdapter(this, new NovaBebidaAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Cardapio bb = CardapioDb.myDataset.get(position);
                Toast.makeText(NovoPedidoActivity.this, bb.toString(), Toast.LENGTH_SHORT).show();
            }
        });*/


        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        //-------------------
        recyclerViewB.setLayoutManager(layoutManagerB);
        recyclerViewB.setAdapter(adapterB);
        recyclerViewB.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

    }
}