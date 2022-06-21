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


public class ListaPedidosAdapter extends RecyclerView.Adapter<ListaPedidosAdapter.MyViewHolder> {

    private LayoutInflater inflater;
    private OnItemClickListener listener;

    public ListaPedidosAdapter(Context context, OnItemClickListener listener) {
        inflater = LayoutInflater.from(context);
        this.listener = listener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemList = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);
        return new MyViewHolder(itemList);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.mesaTv.setText(String.valueOf(MesaDb.myDataset.get(position).getNumMesa()));
        holder.comandaTv.setText(String.valueOf(MesaDb.myDataset.get(position).getNumComanda()));
    }

    @Override
    public int getItemCount() {return MesaDb.myDataset.size();}

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        public TextView comandaTv;
        public TextView mesaTv;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            mesaTv = itemView.findViewById(R.id.mesa_num);
            comandaTv = itemView.findViewById(R.id.comanda_num);
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
