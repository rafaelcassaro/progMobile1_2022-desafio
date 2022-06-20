package com.example.pi.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.pi.R;
import com.example.pi.adapter.NovaBebidaAdapter;
import com.example.pi.adapter.NovoCardapioAdapter;
import com.example.pi.db.AlimentosDb;
import com.example.pi.db.BebidaDb;
import com.example.pi.models.Alimento;
import com.example.pi.models.Comanda;
import com.example.pi.models.Mesa;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NovoPedidoActivity extends AppCompatActivity {

    public static final String EXTRA_NEW_CONTACT = "EXTRA_NEW_CONTACT";
    private String valorStr = "";
    int qntdInt = 0;
    private RecyclerView recyclerView;
    private NovoCardapioAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    //-----------------

    private Button novo_pedido;
    private TextView novo_mesa;
    private TextView novo_comanda;
    private TextView add_alimento_tv;
    private TextView add_bebida_tv;




    //----------------
    RecyclerView recyclerViewB;
    NovaBebidaAdapter adapterB;
    RecyclerView.LayoutManager layoutManagerB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novo_pedido);

        novo_pedido = findViewById(R.id.novo_pedido_bt);
        novo_mesa = findViewById(R.id.novo_mesa_tv);
        novo_comanda = findViewById(R.id.novo_comanda_tv);

        add_alimento_tv = findViewById(R.id.qnt_alimento_tv);
        add_bebida_tv = findViewById(R.id.qnt_bebida_tv);

        recyclerView = findViewById(R.id.cardapio_rv);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        //---------------------
        recyclerViewB = findViewById(R.id.bebida_rv);
        recyclerViewB.setHasFixedSize(true);
        layoutManagerB = new LinearLayoutManager(this);




        novo_pedido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Date now = new Date(System.currentTimeMillis());
                final String mesaAdd = novo_mesa.getText().toString();
                final String comandaAdd = novo_comanda.getText().toString();
               // final String alimentoAdd = add_alimento_tv.getText().toString();
               // final String alimentoAdd = add_alimento_tv.toString()

                if (mesaAdd.length() == 0){
                    novo_mesa.requestFocus();
                    novo_mesa.setError("Preencha o campo");
                }
                else if(comandaAdd.length() == 0){
                    novo_comanda.requestFocus();
                    novo_comanda.setError("Preencha o campo");
                }
                else{

                    Intent data = new Intent();
                    List<Alimento> alimentosStep = new ArrayList<>();
                    //List<Alimento> alimentosStep2 = new ArrayList<>();
                    //alimentosStep.clear();
                    alimentosStep.addAll(AlimentosDb.myDataset);
                    alimentosStep.addAll(BebidaDb.myDataset);

                    for(int p = alimentosStep.size()-1; p >= 0; p--){
                        //int x = alimentosStep.get(p).getQntd();
                        if(alimentosStep.get(p).getQntd() == 0){
                            alimentosStep.remove(p);
                        }
                    }

                    Comanda comanda = new Comanda("",Integer.parseInt(comandaAdd), alimentosStep);
                    Mesa mesa = new Mesa(Integer.parseInt(mesaAdd),comanda);

                    //mesa.getComanda().setNumComanda(Integer.parseInt(comandaAdd));
                    mesa.getComanda().setMoment(now);


                    //mesa.getComanda().setAlimento(AlimentosDb.myDataset.get(alimentoAdd.));

                    data.putExtra(EXTRA_NEW_CONTACT,  mesa);
                    setResult(RESULT_OK, data);


                    finish();


                }
            }
        });


        adapter = new NovoCardapioAdapter(this, new NovoCardapioAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                //Cardapio cardapio = CardapioDb.myDataset.get(position);
                //Toast.makeText(NovoPedidoActivity.this, cardapio.toString(), Toast.LENGTH_SHORT).show();
            }
        });
        //-------------

        adapterB = new NovaBebidaAdapter(this, new BebidaDb());

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