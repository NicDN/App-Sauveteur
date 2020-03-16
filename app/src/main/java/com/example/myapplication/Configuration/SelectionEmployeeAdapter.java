package com.example.myapplication.Configuration;

import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

import java.util.ArrayList;


public class SelectionEmployeeAdapter extends RecyclerView.Adapter<SelectionEmployeeAdapter.ViewHolder> {

    private ArrayList<ItemSelectionEmployee>listSelectionEmployee_;

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public ImageView imageEmployee;
        public TextView txtViewNom;
        public TextView txtViewHeuresTravail;

        public ViewHolder(View itemView){
            super(itemView);
            imageEmployee=itemView.findViewById(R.id.imageEmployee);
            txtViewNom=itemView.findViewById(R.id.txtViewNom);
            txtViewHeuresTravail=itemView.findViewById(R.id.txtViewHeureTravail);
        }
    }

    public SelectionEmployeeAdapter(ArrayList<ItemSelectionEmployee> listSelectionEmployee){
        listSelectionEmployee_=listSelectionEmployee;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.quarts,parent,false);
        ViewHolder vh=new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ItemSelectionEmployee currentItem=listSelectionEmployee_.get(position);

        //Assigne le nom, heures travail et image au viewholder
        holder.imageEmployee.setImageResource(currentItem.getImageRessource());
        holder.txtViewNom.setText(currentItem.getNom());
        holder.txtViewHeuresTravail.setText(currentItem.getHeuresTravail());

    }

    @Override
    public int getItemCount() {
        return listSelectionEmployee_.size();
    }
}
