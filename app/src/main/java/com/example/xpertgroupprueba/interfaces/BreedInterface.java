package com.example.xpertgroupprueba.interfaces;

import com.example.xpertgroupprueba.Endpoints;
import com.example.xpertgroupprueba.model.BreedModel;
import com.example.xpertgroupprueba.model.ImagesModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface BreedInterface {
    @GET(Endpoints.GET_Breeds)
    public Call<List<BreedModel>> getBreeds();

    @GET(Endpoints.GET_Image_Breed)
    public Call<List<ImagesModel>> getImageBreeds(@Query("breed_id") String breed_id);
}
