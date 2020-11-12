package com.example.xpertgroupprueba.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.example.xpertgroupprueba.R;
import com.example.xpertgroupprueba.Room.VoteRepository;
import com.example.xpertgroupprueba.model.ImagesModel;
import com.example.xpertgroupprueba.model.VoteModel;
import com.example.xpertgroupprueba.model_view.ImagesViewModel;
import com.example.xpertgroupprueba.ui.images.ImagesFragment;
import com.example.xpertgroupprueba.ui.vote.VoteFragment;
import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ImagesAdapter extends RecyclerView.Adapter<ImagesAdapter.ImagesViewHolder> {
    private List<ImagesModel> imagesList = new ArrayList<>();
    private OnItemClickListener mListener;
    @NonNull
    @Override
    public ImagesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ImagesViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.image_list_item, parent, false));
    }

    @Override
    public int getItemViewType(int position) {
        return position + 2;
    }

    @Override
    public void onBindViewHolder(@NonNull final ImagesViewHolder holder, final int position) {

        Picasso.with(holder.img.getContext()).load(imagesList.get(position).getUrl()).into(holder.img);
    }

    @Override
    public int getItemCount() {
        return imagesList.size();
    }

    public void setList(List<ImagesModel> pList) {
        this.imagesList = pList;
        notifyDataSetChanged();
    }

    public class ImagesViewHolder extends RecyclerView.ViewHolder {
        Button votar;
        ImageView img;
        public ImagesViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img);
            votar = itemView.findViewById(R.id.votar);
            votar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int index = getAdapterPosition();
                    if (mListener != null && index != RecyclerView.NO_POSITION){
                        mListener.OnItemClick(imagesList.get(index));
                    }
                }
            });
        }
    }
    public interface OnItemClickListener{void OnItemClick(ImagesModel imagesModel);}
    public void OnItemClickListener(OnItemClickListener listerner){mListener=listerner;}

}