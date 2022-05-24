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


public class NovaBebidaAdapter extends RecyclerView.Adapter<NovaBebidaAdapter.MyViewHolder> {
    private LayoutInflater inflater;
    private NovaBebidaAdapter.OnItemClickListener listener;


    public NovaBebidaAdapter(Context context, OnItemClickListener listener) {
        inflater = LayoutInflater.from(context);
        this.listener =  listener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemList = inflater.inflate(R.layout.bebida_layout, parent, false);
        return new MyViewHolder(itemList);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Cardapio bb = CardapioDb.myDataset.get(position);
        holder.bebida.setText(bb.getBebida());
        holder.qntBebida.setText(String.valueOf(bb.getQntdBebida()));
    }

    @Override
    public int getItemCount() {
        return  CardapioDb.myDataset.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        public TextView bebida;
        public TextView qntBebida;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            bebida = itemView.findViewById(R.id.bb_tv);
            qntBebida =itemView.findViewById(R.id.qnt_bebida_tv);
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
