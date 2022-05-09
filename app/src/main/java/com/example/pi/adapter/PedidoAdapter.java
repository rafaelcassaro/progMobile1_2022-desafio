package com.example.pi.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pi.R;
import com.example.pi.activities.DetalhesPedidosActivity;
import com.example.pi.models.Pedido;
import com.example.pi.models.PedidoDb;
import com.example.pi.viewHolders.PedidoViewHolder;


public class PedidoAdapter extends RecyclerView.Adapter<PedidoViewHolder> {

    LayoutInflater inflater;
    OnItemClickListener listener;
    private View itemList;


    public PedidoAdapter(Context context, OnItemClickListener listener) {
        inflater = LayoutInflater.from(context);
        this.listener = listener;
    }

    @NonNull
    @Override
    public PedidoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        itemList = inflater.inflate(R.layout.item_layout, parent, false);
        return new PedidoViewHolder(itemList);
    }

    @Override
    public void onBindViewHolder(@NonNull PedidoViewHolder holder, int position) {
        Pedido pedido = PedidoDb.myDataset.get(position);
        holder.pedido.setText(pedido.getPedido());
        holder.mesa.setText(pedido.getMesa());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(itemList.getContext(), DetalhesPedidosActivity.class);
                itemList.getContext().startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return PedidoDb.myDataset.size();
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

}
