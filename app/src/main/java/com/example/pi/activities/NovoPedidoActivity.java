package com.example.pi.activities;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
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
import com.example.pi.db.MesaDb;
import com.example.pi.models.Alimento;
import com.example.pi.models.Comanda;
import com.example.pi.models.Mesa;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NovoPedidoActivity extends AppCompatActivity {

    public static final String EXTRA_NEW_CONTACT = "EXTRA_NEW_CONTACT";
    private String valorStr = "";
    private Button novo_pedido;
    private TextView novo_mesa;
    private TextView novo_comanda;
    private TextView add_alimento_tv;
    private TextView add_bebida_tv;

    private RecyclerView recyclerView;
    private NovoCardapioAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView recyclerViewB;
    private NovaBebidaAdapter adapterB;
    private RecyclerView.LayoutManager layoutManagerB;

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
                AlertDialog.Builder confirmaInclusao = new AlertDialog.Builder(NovoPedidoActivity.this);
                Date now = new Date(System.currentTimeMillis());
                final String mesaAdd = novo_mesa.getText().toString();
                final String comandaAdd = novo_comanda.getText().toString();

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
                    alimentosStep.addAll(AlimentosDb.myDataset);
                    alimentosStep.addAll(BebidaDb.myDataset);

                    for(int p = alimentosStep.size()-1; p >= 0; p--){
                        if(alimentosStep.get(p).getQntd() == 0){
                            alimentosStep.remove(p);
                        }
                    }

                    Comanda comanda = new Comanda("",Integer.parseInt(comandaAdd), alimentosStep);

                    confirmaInclusao.setTitle("Atenção!");
                    confirmaInclusao.setMessage("Deseja incluir o pedido \n" +"Mesa " +mesaAdd+ "    Comanda "+ comandaAdd+"\n"+  comanda.printAlimentos() );
                    confirmaInclusao.setCancelable(false);
                    confirmaInclusao.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            Mesa mesa = new Mesa(Integer.parseInt(mesaAdd),comanda);
                            mesa.getComanda().setMoment(now);

                            data.putExtra(EXTRA_NEW_CONTACT,  mesa);
                            setResult(RESULT_OK, data);
                            finish();
                        }
                    });
                    confirmaInclusao.setNegativeButton("Não", null);
                    confirmaInclusao.create().show();

                }
            }
        });


        adapter = new NovoCardapioAdapter(this,new AlimentosDb());
        //-------------
        adapterB = new NovaBebidaAdapter(this, new BebidaDb());

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        //-------------------
        recyclerViewB.setLayoutManager(layoutManagerB);
        recyclerViewB.setAdapter(adapterB);
        recyclerViewB.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

    }
}