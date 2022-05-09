package com.example.pi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pi.R;
import com.example.pi.models.Bebida;
import com.example.pi.models.BebidaDb;
import com.example.pi.models.Cardapio;
import com.example.pi.models.CardapioDb;
import com.example.pi.viewHolders.BebidaViewHolder;

public class BebidaAdapter extends RecyclerView.Adapter<BebidaViewHolder> {
    LayoutInflater inflater;
    BebidaAdapter.OnItemClickListener listener;
    private View itemList;

    public BebidaAdapter(Context context, BebidaAdapter.OnItemClickListener listener) {
        inflater = LayoutInflater.from(context);
        this.listener =  listener;
    }

    @NonNull
    @Override
    public BebidaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        itemList = inflater.inflate(R.layout.bebida_layout, parent, false);
        return new BebidaViewHolder(itemList);
    }

    @Override
    public void onBindViewHolder(@NonNull BebidaViewHolder holder, int position) {
        Bebida bb = BebidaDb.myDataset.get(position);
        holder.bebida.setText(bb.getBebida());
    }

    @Override
    public int getItemCount() {
        return  BebidaDb.myDataset.size();
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }
}
