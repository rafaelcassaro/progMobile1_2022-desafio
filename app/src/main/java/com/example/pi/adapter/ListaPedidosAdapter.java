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
import com.example.pi.models.MesaDb;
import com.example.pi.models.Pedido;
import com.example.pi.models.PedidoDb;


public class ListaPedidosAdapter extends RecyclerView.Adapter<ListaPedidosAdapter.MyViewHolder> {

    private LayoutInflater inflater;
    private OnItemClickListener listener;
    private View itemList;


    public ListaPedidosAdapter(Context context, OnItemClickListener listener) {
        inflater = LayoutInflater.from(context);
        this.listener = listener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //itemList = inflater.inflate(R.layout.item_layout, parent, false);
        itemList = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);
        return new MyViewHolder(itemList);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Mesa mesadb = MesaDb.myDataset.get(position);
        //holder
        //String doidera = String.valueOf(PedidoDb.myDataset.get(position));
        //holder.pedido.setText(mesadb.getPedido());
        holder.mesaTv.setText(String.valueOf(position+1));
        //holder.mesa.setText(mesadb(position+1));

        /*holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(itemList.getContext(), DetalhesPedidosActivity.class);
                itemList.getContext().startActivity(i);
            }
        });*/

    }

    @Override
    public int getItemCount() {return MesaDb.myDataset.size();}

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
       // public TextView pedido;
        public TextView mesaTv;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            mesaTv = itemView.findViewById(R.id.mesa_num);
         //   pedido = itemView.findViewById(R.id.comanda_num);
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
