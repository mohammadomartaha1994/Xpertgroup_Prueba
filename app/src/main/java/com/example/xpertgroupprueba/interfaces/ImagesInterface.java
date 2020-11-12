package com.example.xpertgroupprueba.interfaces;

import com.example.xpertgroupprueba.Endpoints;
import com.example.xpertgroupprueba.model.ImagesModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface ImagesInterface {
    @GET(Endpoints.GET_Images)
    public Call<List<ImagesModel>> getImages();
}
