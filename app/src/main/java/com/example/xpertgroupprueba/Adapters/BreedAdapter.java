package com.example.xpertgroupprueba.Adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.xpertgroupprueba.R;
import com.example.xpertgroupprueba.model.BreedModel;
import com.example.xpertgroupprueba.model.ImagesModel;
import com.example.xpertgroupprueba.ui.breed.BreedDetails;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class BreedAdapter extends RecyclerView.Adapter<BreedAdapter.BreedViewHolder> {
    private List<BreedModel> breedList = new ArrayList<>();

    @NonNull
    @Override
    public BreedAdapter.BreedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new BreedAdapter.BreedViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.breed_list_item, parent, false));
    }

    @Override
    public int getItemViewType(int position) {
        return position + 2;
    }

    @Override
    public void onBindViewHolder(@NonNull final BreedAdapter.BreedViewHolder holder, final int position) {
        holder.name.setText(breedList.get(position).getName()+"");
        holder.origin.setText(breedList.get(position).getOrigin()+"");
        holder.temperament.setText(breedList.get(position).getTemperament()+"");
        holder.btn_view_breed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToDetails = new Intent(holder.btn_view_breed.getContext(), BreedDetails.class);
                goToDetails.putExtra("id",breedList.get(position).getId()+"");
                goToDetails.putExtra("name",breedList.get(position).getName()+"");
                goToDetails.putExtra("description",breedList.get(position).getDescription()+"");
                goToDetails.putExtra("origin",breedList.get(position).getOrigin()+"");
                goToDetails.putExtra("temperament",breedList.get(position).getTemperament()+"");
                goToDetails.putExtra("imperial",breedList.get(position).getWeight().getImperial()+"");
                goToDetails.putExtra("wikipedia_url",breedList.get(position).getWikipediaUrl()+"");
                holder.btn_view_breed.getContext().startActivity(goToDetails);
            }
        });

    }

    @Override
    public int getItemCount() {
        return breedList.size();
    }

    public void setList(List<BreedModel> pList) {
        this.breedList = pList;
        notifyDataSetChanged();
    }

    public class BreedViewHolder extends RecyclerView.ViewHolder {
        TextView name,origin,temperament;
        Button btn_view_breed;
        public BreedViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            origin = itemView.findViewById(R.id.origin);
            temperament = itemView.findViewById(R.id.temperament);
            btn_view_breed = itemView.findViewById(R.id.btn_view_breed);

        }
    }
}