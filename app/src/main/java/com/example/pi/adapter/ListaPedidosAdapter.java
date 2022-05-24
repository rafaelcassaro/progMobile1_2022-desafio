package com.example.pi.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pi.R;
import com.example.pi.activities.DetalhesPedidosActivity;
import com.example.pi.models.Pedido;
import com.example.pi.models.PedidoDb;


public class ListaPedidosAdapter extends RecyclerView.Adapter<ListaPedidosAdapter.MyViewHolder> {

    private LayoutInflater inflater;
    private OnItemClickListener listener;
    //private View itemList;


    public ListaPedidosAdapter(Context context, OnItemClickListener listener) {
        inflater = LayoutInflater.from(context);
        this.listener = listener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemList = inflater.inflate(R.layout.item_layout, parent, false);
        return new MyViewHolder(itemList);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Pedido pedido = PedidoDb.myDataset.get(position);
        holder.pedido.setText(pedido.getPedido());
        holder.mesa.setText(pedido.getMesa());

        /*holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(itemList.getContext(), DetalhesPedidosActivity.class);
                itemList.getContext().startActivity(i);
            }
        });*/

    }

    @Override
    public int getItemCount() {
        return PedidoDb.myDataset.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        public TextView pedido;
        public TextView mesa;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            pedido = itemView.findViewById(R.id.bb_tv);
            mesa = itemView.findViewById(R.id.numeroMesa_TextView);
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
