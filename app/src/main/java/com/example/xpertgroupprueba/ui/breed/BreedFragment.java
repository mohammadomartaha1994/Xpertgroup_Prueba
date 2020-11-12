package com.example.xpertgroupprueba.ui.breed;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.xpertgroupprueba.Adapters.BreedAdapter;
import com.example.xpertgroupprueba.Adapters.ImagesAdapter;
import com.example.xpertgroupprueba.R;
import com.example.xpertgroupprueba.model.BreedModel;
import com.example.xpertgroupprueba.model.ImagesModel;
import com.example.xpertgroupprueba.model_view.BreedViewModel;
import com.example.xpertgroupprueba.model_view.ImagesViewModel;

import java.util.List;

public class BreedFragment extends Fragment {

    private BreedViewModel breedViewModel;
    private RecyclerView recyclerView;
    ProgressBar loading;
    BreedAdapter adapter;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        breedViewModel = new ViewModelProvider(this).get(BreedViewModel.class);
        View root = inflater.inflate(R.layout.fragment_breed, container, false);
        return root;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        loading = getActivity().findViewById(R.id.progressBarBreed);
        breedViewModel.getBreeds();
        recyclerView =getActivity().findViewById(R.id.breedlist);
        adapter = new BreedAdapter();
        Log.d("test 1",adapter.getItemCount()+"");
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);
        breedViewModel.breedMutableLiveData.observe(getViewLifecycleOwner(), new Observer<List<BreedModel>>() {
            @Override
            public void onChanged(List<BreedModel> breedModels) {
                loading.setVisibility(View.GONE);
                adapter.setList(breedModels);
            }
        });

    }
}