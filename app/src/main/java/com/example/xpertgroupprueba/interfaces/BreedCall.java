package com.example.xpertgroupprueba.interfaces;

import com.example.xpertgroupprueba.Endpoints;
import com.example.xpertgroupprueba.model.BreedModel;
import com.example.xpertgroupprueba.model.ImagesModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BreedCall {
    private BreedInterface breedInterface;
    private static BreedCall INSTANCE;

    public BreedCall() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Endpoints.URL_BASE)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        breedInterface = retrofit.create(BreedInterface.class);
    }

    public static BreedCall getINSTANCE() {
        if (null == INSTANCE){
            INSTANCE = new BreedCall();
        }
        return INSTANCE;
    }

    public Call<List<BreedModel>> getBreeds(){
        return breedInterface.getBreeds();
    }
    public Call<List<ImagesModel>> getImageBreed(String breed_id){
        return breedInterface.getImageBreeds(breed_id);
    }
}

