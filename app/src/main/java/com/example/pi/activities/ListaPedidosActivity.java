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

import com.example.pi.R;
import com.example.pi.adapter.ListaPedidosAdapter;
import com.example.pi.models.Mesa;
import com.example.pi.models.MesaDb;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ListaPedidosActivity extends AppCompatActivity {

    public static final String EXTRA_SHOW = "EXTRA_SHOW";
    private static final int ADD_CONTACT_REQUEST = 1;
    private RecyclerView recyclerView;
    //private ListaPedidosAdapter adapter;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;



    ActivityResultLauncher<Intent> mStartForResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        Intent data = result.getData();
                        Mesa mesa = (Mesa) data.getSerializableExtra(NovoPedidoActivity.EXTRA_NEW_CONTACT);
                        MesaDb.myDataset.add(mesa);
                        adapter.notifyDataSetChanged();
                    }
                }
            });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_pedidos);

        recyclerView = findViewById(R.id.main_recyclerView);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new ListaPedidosAdapter(this, new ListaPedidosAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent intent = new Intent(ListaPedidosActivity.this, DetalhesPedidosActivity.class);
                intent.putExtra(EXTRA_SHOW, MesaDb.myDataset.get(position));

                startActivity(intent);
            }
        });



        FloatingActionButton add_pedido = findViewById(R.id.add_pedido);
        add_pedido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ListaPedidosActivity.this, NovoPedidoActivity.class);
                mStartForResult.launch(i);
                //startActivity(i);
            }
        });

        recyclerView.setAdapter(adapter);

        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

    }

}