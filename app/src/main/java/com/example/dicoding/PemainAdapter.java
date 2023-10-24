package com.example.dicoding;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PemainAdapter extends RecyclerView.Adapter<PemainAdapter.ListViewHolder> {

    private ArrayList<Pemain> pemains;
    private Context context;
    private selectedItem listener;

    public PemainAdapter(ArrayList<Pemain> listPemains, Context context, selectedItem listener){
        this.listener = listener;
        this.pemains = listPemains;
        this.context = context;

    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Pemain pemain = pemains.get(position);
        holder.imagePhoto.setImageResource(pemain.get_photo());
        holder.pemainName.setText(pemain.get_nama());
        holder.pemainDescription.setText(pemain.get_deskripsi());

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.selectedItemClick(pemains.get(position));
            }
        });

    }

    @Override
    public int getItemCount() {
        return pemains.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imagePhoto;
        TextView pemainName,pemainDescription;
        public CardView cardView;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            imagePhoto = itemView.findViewById(R.id.img_item_photo);
            pemainName = itemView.findViewById(R.id.tv_item_name);
            pemainDescription = itemView.findViewById(R.id.tv_item_description);
            cardView = itemView.findViewById(R.id.card_view);
        }
    }
}
