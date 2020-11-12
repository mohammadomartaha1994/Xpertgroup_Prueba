package com.example.xpertgroupprueba.ui.images;

import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.xpertgroupprueba.Adapters.ImagesAdapter;
import com.example.xpertgroupprueba.Adapters.VoteAdapter;
import com.example.xpertgroupprueba.R;
import com.example.xpertgroupprueba.model.ImagesModel;
import com.example.xpertgroupprueba.model.VoteModel;
import com.example.xpertgroupprueba.model_view.ImagesViewModel;
import com.example.xpertgroupprueba.model_view.VoteViewModel;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ImagesFragment extends Fragment {

    private ImagesViewModel imagesViewModel;
    private RecyclerView recyclerView;
    ProgressBar loading;
    ImagesAdapter adapter;
    private VoteViewModel voteViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        imagesViewModel = new ViewModelProvider(this).get(ImagesViewModel.class);
        voteViewModel = new ViewModelProvider(this).get(VoteViewModel.class);
        View root = inflater.inflate(R.layout.fragment_images, container, false);
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        loading = getActivity().findViewById(R.id.progressBar);
        imagesViewModel.getImages();
        recyclerView =getActivity().findViewById(R.id.imagelist);
        adapter = new ImagesAdapter();
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        recyclerView.setAdapter(adapter);
        imagesViewModel.imagesMutableLiveData.observe(getViewLifecycleOwner(), new Observer<List<ImagesModel>>() {
            @Override
            public void onChanged(List<ImagesModel> imagesModels) {
                loading.setVisibility(View.GONE);
                adapter.setList(imagesModels);
            }
        });

        adapter.OnItemClickListener(new ImagesAdapter.OnItemClickListener() {
            @Override
            public void OnItemClick(ImagesModel imagesModel) {
                SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
                Date date = new Date(System.currentTimeMillis());
                VoteModel voteModelItem = new VoteModel(imagesModel.getUrl(),formatter.format(date)+"",imagesModel.getId());
                voteViewModel.insert(voteModelItem);
                Toast.makeText(getActivity(),"Gracias por Votar",Toast.LENGTH_SHORT).show();
            }
        });
    }

}