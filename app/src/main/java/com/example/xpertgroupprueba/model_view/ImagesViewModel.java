package com.example.xpertgroupprueba.model_view;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.xpertgroupprueba.Room.VoteRepository;
import com.example.xpertgroupprueba.interfaces.ImagesCall;
import com.example.xpertgroupprueba.model.ImagesModel;
import com.example.xpertgroupprueba.model.VoteModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ImagesViewModel extends ViewModel {
    public MutableLiveData<List<ImagesModel>> imagesMutableLiveData = new MutableLiveData<>();
    MutableLiveData<String> failure = new MutableLiveData<>();
    private VoteRepository voteRepository;

    public void getImages() {
        ImagesCall.getINSTANCE().getImages().enqueue(new Callback<List<ImagesModel>>() {
            @Override
            public void onResponse(Call<List<ImagesModel>> call, Response<List<ImagesModel>> response) {
                imagesMutableLiveData.setValue(response.body());
            }
            @Override
            public void onFailure(Call<List<ImagesModel>> call, Throwable t) {
                failure.setValue("Error");
            }
        });
    }
    public void insertVote(VoteModel voteModel) {
        voteRepository.insert(voteModel);
    }

}