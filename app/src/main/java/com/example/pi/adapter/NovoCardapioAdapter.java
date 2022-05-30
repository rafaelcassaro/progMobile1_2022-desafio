package com.example.pi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pi.R;
import com.example.pi.models.Alimento;
import com.example.pi.models.AlimentosDb;


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
        Alimento cardapio = AlimentosDb.myDataset.get(position);
        holder.prato.setText(cardapio.getProduto());
        holder.detalhe.setText(cardapio.getDetalhe());
        holder.addPrato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cardapio.setQntd(cardapio.getQntd()+1);
                holder.qntdPrato.setText(String.valueOf(cardapio.getQntd()));
            }
        });
        holder.removePrato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cardapio.getQntd() > 0) {
                    cardapio.setQntd(cardapio.getQntd() - 1);
                    holder.qntdPrato.setText(String.valueOf(cardapio.getQntd()));
                }
            }
        });



    }


    @Override
    public int getItemCount() {
        return AlimentosDb.myDataset.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder
    {
        public TextView prato;
        public TextView detalhe;
        public TextView qntdPrato;
        public ImageButton removePrato;
        public ImageButton addPrato;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            prato = itemView.findViewById(R.id.titulo_alimento_tv);
            detalhe = itemView.findViewById(R.id.detalhes_alimento_tv);
            removePrato = itemView.findViewById(R.id.remove_alimento_bt);
            addPrato = itemView.findViewById(R.id.add_alimento_bt);
            qntdPrato = itemView.findViewById(R.id.qnt_alimento_tv);

        }


    }


    public interface OnItemClickListener {
        void onItemClick(int position);
    }


}