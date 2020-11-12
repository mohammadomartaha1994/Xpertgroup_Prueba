package com.example.xpertgroupprueba.Adapters;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.xpertgroupprueba.R;
import com.example.xpertgroupprueba.model.VoteModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class VoteAdapter extends RecyclerView.Adapter<VoteAdapter.VoteViewHolder> {
    private List<VoteModel> votesList = new ArrayList<>();
    private OnItemClickListener mListener;
    @NonNull
    @Override
    public VoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new VoteViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.vote_item, parent, false));
    }
    @Override
    public int getItemViewType(int position) { return position+2;}

    @Override
    public void onBindViewHolder(@NonNull final VoteViewHolder holder, final int position) {
        holder.voteDate.setText(votesList.get(position).dateVote());
        holder.imageidentifier.setText("Identificador : "+votesList.get(position).imageidentifier());
        Picasso.with(holder.URLImageVote.getContext()).load(votesList.get(position).uRLImageVote()).into(holder.URLImageVote);
    }

    @Override
    public int getItemCount() {
        return votesList.size();
    }

    public void setList(List<VoteModel> uList) {
        this.votesList = uList;
        notifyDataSetChanged();
    }

    public class VoteViewHolder extends RecyclerView.ViewHolder {
        TextView voteDate,imageidentifier;
        ImageView URLImageVote;
        public VoteViewHolder(@NonNull View itemView) {
            super(itemView);
            voteDate = itemView.findViewById(R.id.date);
            imageidentifier = itemView.findViewById(R.id.imageidentifier);
            URLImageVote = itemView.findViewById(R.id.img);
        }
    }
    public interface OnItemClickListener{void OnItemClick(VoteModel voteModel);}
}


