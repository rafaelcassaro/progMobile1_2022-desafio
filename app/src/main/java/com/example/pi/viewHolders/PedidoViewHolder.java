package com.example.pi.viewHolders;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pi.R;
import com.example.pi.adapter.PedidoAdapter;

public class PedidoViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener  {
    PedidoAdapter.OnItemClickListener listener;
    public TextView pedido;
    public TextView mesa;



    public PedidoViewHolder(@NonNull View itemView) {
        super(itemView);
        pedido = itemView.findViewById(R.id.bb_tv);
        mesa = itemView.findViewById(R.id.numeroMesa_TextView);
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        listener.onItemClick(getAdapterPosition());
    }
}