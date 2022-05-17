package com.example.billigtlager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.example.billigtlager.db.Depotrum;

import java.util.List;

public class DepotrumListAdapter extends RecyclerView.Adapter<DepotrumListAdapter.MyViewHolder> {

    List<Depotrum> depotrumList;
    public DepotrumListAdapter(List<Depotrum> list){
        this.depotrumList = list;
    }

    public void setDepotrumList(List<Depotrum> depotrumList) {
         this.depotrumList = depotrumList;
         notifyDataSetChanged();

    }

    @NonNull
    @Override
    public DepotrumListAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_room3x4, parent, false);
            DepotrumListAdapter.MyViewHolder myViewHolder = new MyViewHolder(view);
    return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DepotrumListAdapter.MyViewHolder holder, int position) {
        holder.tvRumNr.setText(this.depotrumList.get(position).rumNr); // hold øje med denne
        holder.tvKM2.setText(this.depotrumList.get(position).km2);
        holder.tvPrice.setText(this.depotrumList.get(position).price);
    }

    @Override
    public int getItemCount() {

        return this.depotrumList.size();
    }

    public class MyViewHolder extends  RecyclerView.ViewHolder{
        TextView tvRumNr;
        TextView tvKM2;
        TextView tvPrice;

        public MyViewHolder(@NonNull View view){
            super(view);
            TextView tvRumNr = view.findViewById(R.id.tvRumNr);
            TextView tvKM2 = view.findViewById(R.id.tvKM2);
            TextView tvPrice = view.findViewById(R.id.tvPrice);


        }
    }
}
