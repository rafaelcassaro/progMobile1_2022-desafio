package com.example.pi.viewHolders;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pi.R;
import com.example.pi.adapter.NovaBebidaAdapter;

public class BebidaViewHolder  extends RecyclerView.ViewHolder implements View.OnClickListener {
    NovaBebidaAdapter.OnItemClickListener listener;
    public TextView bebida;


    public BebidaViewHolder(@NonNull View itemView) {
        super(itemView);
        bebida = itemView.findViewById(R.id.bb_tv);
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        listener.onItemClick(getAdapterPosition());

    }
}
