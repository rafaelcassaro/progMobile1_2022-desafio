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
import com.example.pi.db.BebidaDb;


public class NovaBebidaAdapter extends RecyclerView.Adapter<NovaBebidaAdapter.MyViewHolder> {
    private BebidaDb alimentosBebida = new BebidaDb();
    private LayoutInflater inflater;


    public NovaBebidaAdapter(Context context, BebidaDb wordList) {
        inflater = LayoutInflater.from(context);
        this.alimentosBebida = wordList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemList = inflater.inflate(R.layout.bebida_layout, parent, false);
        return new MyViewHolder(itemList);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Alimento bb = BebidaDb.myDataset.get(position);
        holder.bebida.setText(bb.getProduto());
        holder.addBebida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bb.setQntd(bb.getQntd()+1);
                holder.qntd.setText(String.valueOf(bb.getQntd()));
            }
        });
        holder.removeBebida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(bb.getQntd() > 0){
                    bb.setQntd(bb.getQntd()-1);
                    holder.qntd.setText(String.valueOf(bb.getQntd()));
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return BebidaDb.myDataset.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder
    {
        public TextView bebida;
        public TextView qntd;
        public ImageButton addBebida;
        public ImageButton removeBebida;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            bebida = itemView.findViewById(R.id.titulo_bebida_tv);
            qntd = itemView.findViewById(R.id.qnt_bebida_tv);
            addBebida = itemView.findViewById(R.id.add_bebida_bt);
            removeBebida = itemView.findViewById(R.id.remove_bebida_bt);

        }
    }
}
