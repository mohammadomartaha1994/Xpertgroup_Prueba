package com.example.xpertgroupprueba.model_view;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.xpertgroupprueba.interfaces.BreedCall;
import com.example.xpertgroupprueba.interfaces.ImagesCall;
import com.example.xpertgroupprueba.model.BreedModel;
import com.example.xpertgroupprueba.model.ImagesModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BreedViewModel extends ViewModel {

    public MutableLiveData<List<BreedModel>> breedMutableLiveData = new MutableLiveData<>();
    public MutableLiveData<List<ImagesModel>> breedImageMutableLiveData = new MutableLiveData<>();
    MutableLiveData<String> failure = new MutableLiveData<>();

    public void getBreeds() {
        BreedCall.getINSTANCE().getBreeds().enqueue(new Callback<List<BreedModel>>() {
            @Override
            public void onResponse(Call<List<BreedModel>> call, Response<List<BreedModel>> response) {
                breedMutableLiveData.setValue(response.body());
            }
            @Override
            public void onFailure(Call<List<BreedModel>> call, Throwable t) {
                failure.setValue("Error");
            }
        });
    }

    public void getImageBreed(String breed_id) {
        BreedCall.getINSTANCE().getImageBreed(breed_id).enqueue(new Callback<List<ImagesModel>>() {
            @Override
            public void onResponse(Call<List<ImagesModel>> call, Response<List<ImagesModel>> response) {
                breedImageMutableLiveData.setValue(response.body());
            }
            @Override
            public void onFailure(Call<List<ImagesModel>> call, Throwable t) {
                failure.setValue("no Image");
                Log.d("no Image error",t+" ");
            }
        });
    }
}