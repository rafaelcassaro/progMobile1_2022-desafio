package com.example.pi.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pi.R;
import com.example.pi.models.Cardapio;
import com.example.pi.models.CardapioDb;
import com.example.pi.viewHolders.CardapioViewHolder;
import com.example.pi.viewHolders.PedidoViewHolder;

public class CardapioAdapter extends RecyclerView.Adapter<CardapioViewHolder> {
    LayoutInflater inflater;
    PedidoAdapter.OnItemClickListener listener;
    private View itemList;

    public CardapioAdapter(Context context, PedidoAdapter.OnItemClickListener listener) {
        inflater = LayoutInflater.from(context);
        this.listener = listener;
    }

    @NonNull
    @Override
    public CardapioViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        itemList = inflater.inflate(R.layout.cardapio_layout, parent, false);
        return new CardapioViewHolder(itemList);
    }

    @Override
    public void onBindViewHolder(@NonNull CardapioViewHolder holder, int position) {
        Cardapio cardapio = CardapioDb.myDataset.get(position);
        holder.titulo.setText(cardapio.getTitulo());
        holder.detalhe.setText(cardapio.getDetalhe());

    }


    @Override
    public int getItemCount() {
        return CardapioDb.myDataset.size();
    }


    public interface OnItemClickListener {
        void onItemClick(int position);
    }


}
