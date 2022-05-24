package com.example.pi.viewHolders;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pi.adapter.NovoCardapioAdapter;

public class CardapioViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    NovoCardapioAdapter.OnItemClickListener listener;
    //public TextView titulo;
    //public TextView detalhe;

    public CardapioViewHolder(@NonNull View itemView) {
        super(itemView);
        //titulo = itemView.findViewById(R.id.titulo_tv);
        //detalhe = itemView.findViewById(R.id.detalhes_tv);
        itemView.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        listener.onItemClick(getAdapterPosition());
    }
}
