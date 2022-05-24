package com.example.pi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pi.R;
import com.example.pi.models.Cardapio;
import com.example.pi.models.CardapioDb;


public class NovoCardapioAdapter extends RecyclerView.Adapter<NovoCardapioAdapter.MyViewHolder> {
    private LayoutInflater inflater;
    private OnItemClickListener listener;
    private View itemList;

    public NovoCardapioAdapter(Context context, OnItemClickListener listener) {
        inflater = LayoutInflater.from(context);
        this.listener = listener;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        itemList = inflater.inflate(R.layout.novopedido_layout, parent, false);
        return new MyViewHolder(itemList);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Cardapio cardapio = CardapioDb.myDataset.get(position);
        holder.titulo.setText(cardapio.getTitulo());
        holder.detalhe.setText(cardapio.getDetalhe());
        holder.qntItem.setText(String.valueOf(cardapio.getQntd()));

    }


    @Override
    public int getItemCount() {
        return CardapioDb.myDataset.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        public TextView titulo;
        public TextView detalhe;
        public TextView qntItem;
        //public ImageButton remove;
        //public ImageButton add;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            titulo = itemView.findViewById(R.id.bb_tv);
            detalhe = itemView.findViewById(R.id.detalhes_tv);
            qntItem = itemView.findViewById(R.id.qnt_bebida_tv);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            listener.onItemClick(getAdapterPosition());
        }
    }


    public interface OnItemClickListener {
        void onItemClick(int position);
    }


}