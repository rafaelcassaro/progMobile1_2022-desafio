package com.example.pi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pi.R;
import com.example.pi.models.Mesa;
import com.example.pi.db.MesaDb;

public class DetalhesPedidosAdapter extends RecyclerView.Adapter<DetalhesPedidosAdapter.MyViewHolder> {
    private MesaDb alimentosBebida = new MesaDb();
    private LayoutInflater inflater;


    public DetalhesPedidosAdapter(Context context, MesaDb wordList) {
        inflater = LayoutInflater.from(context);
        this.alimentosBebida = wordList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemList = inflater.inflate(R.layout.detalhes_layout, parent, false);
        return new MyViewHolder(itemList);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Mesa bb = MesaDb.myDataset.get(position);
        //holder.produto.setText((CharSequence) bb.getListAlimentos());
        //holder.qntde.setText(String.valueOf(bb.getQntd()));
    }

    @Override
    public int getItemCount() {
        return MesaDb.myDataset.size();
    }



    public class MyViewHolder extends RecyclerView.ViewHolder
    {
        public TextView produto;
        //public TextView qntde;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            produto = itemView.findViewById(R.id.detalhes_pedido_tv);
            //qntde = itemView.findViewById(R.id.qntd_detalhes_tv);


        }


    }

}
