package com.example.billigtlager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.billigtlager.db.Depotrum;

import java.util.List;

public class DepotrumListAdapter extends RecyclerView.Adapter<DepotrumListAdapter.MyViewHolder> {

    private Context context;
    private List<Depotrum> depotrumList;
    public DepotrumListAdapter(Context context){
        this.context = context;
    }

    public void setDepotrumList(List<Depotrum> depotrumList) {
         this.depotrumList = depotrumList;
         notifyDataSetChanged();

    }

    @NonNull
    @Override
    public DepotrumListAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_row, parent, false);

    return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DepotrumListAdapter.MyViewHolder holder, int position) {
        holder.tvRumNr.setText(this.depotrumList.get(position).rumNr);
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

        public MyViewHolder(View view){
            super(view);
            TextView tvRumNr = view.findViewById(R.id.tvRumNr);
            TextView tvKM2 = view.findViewById(R.id.tvKM2);
            TextView tvPrice = view.findViewById(R.id.tvPrice);


        }
    }
}
