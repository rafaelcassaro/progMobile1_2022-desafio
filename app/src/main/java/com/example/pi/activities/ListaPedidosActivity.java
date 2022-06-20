package com.example.pi.activities;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.pi.R;
import com.example.pi.adapter.ListaPedidosAdapter;
import com.example.pi.db.AlimentosDb;
import com.example.pi.db.BebidaDb;
import com.example.pi.models.Alimento;
import com.example.pi.models.Mesa;
import com.example.pi.db.MesaDb;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;


public class ListaPedidosActivity extends AppCompatActivity {

    public static final String EXTRA_SHOW = "EXTRA_SHOW";
    private static final int ADD_CONTACT_REQUEST = 1;
    private RecyclerView recyclerView;
    //private ListaPedidosAdapter adapter;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private TextView nome_novo;
    private TextView name_visu;
    private String nomeSalvo;


    ActivityResultLauncher<Intent> mStartForResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        Intent data = result.getData();
                        Mesa mesa = (Mesa) data.getSerializableExtra(NovoPedidoActivity.EXTRA_NEW_CONTACT);
                        mesa.getComanda().setNomeGarcom(nomeSalvo);
                        MesaDb.myDataset.add(mesa);

                        for(int p =0 ; p < AlimentosDb.myDataset.size();p++){
                            AlimentosDb.myDataset.get(p).setQntd(0);
                        }
                        for(int p =0 ; p < BebidaDb.myDataset.size();p++){
                            BebidaDb.myDataset.get(p).setQntd(0);
                        }

                        adapter.notifyDataSetChanged();
                    }
                }
            });

    ActivityResultLauncher<Intent> mStartForResult2 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult result) {
            if(result.getResultCode() == Activity.RESULT_OK){
                adapter.notifyDataSetChanged();
            }
        }
    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_pedidos);

        nome_novo = findViewById(R.id.new_name_tv);
        name_visu = findViewById(R.id.name_tv);
        //String dsdes = "hello";
        //name_visu.setText(nomeSalvo);

        recyclerView = findViewById(R.id.main_recyclerView);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);



        adapter = new ListaPedidosAdapter(this, new ListaPedidosAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent intent = new Intent(ListaPedidosActivity.this, DetalhesPedidosActivity.class);
                intent.putExtra(EXTRA_SHOW, MesaDb.myDataset.get(position));
                mStartForResult2.launch(intent);
            }
        });



        FloatingActionButton add_pedido = findViewById(R.id.add_pedido);
        add_pedido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String nomeNovo = nome_novo.getText().toString();
                final String nomeN = name_visu.getText().toString();
                //nomeSalvo = nomeNovo;

                if(nomeN.length() == 0){
                    nome_novo.setError(null);
                    nomeSalvo = nomeNovo;
                    name_visu.setText(nomeSalvo);

                    nome_novo.requestFocus();
                    nome_novo.setError("Preencha o campo");

                }
                //else if(nomeNovo == "chave"){
                //    name_visu.setText(nomeSalvo);
                //    nomeSalvo = nomeNovo;
                //}
                else {

                    //name_visu.setText(nomeSalvo);
                    nome_novo.setError(null);
                    nome_novo.setText(null);

                    Intent i = new Intent(ListaPedidosActivity.this, NovoPedidoActivity.class);
                    mStartForResult.launch(i);

                    //startActivity(i);
                }
            }
        });

        recyclerView.setAdapter(adapter);

        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

    }

}