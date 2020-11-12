package com.example.xpertgroupprueba.interfaces;

import com.example.xpertgroupprueba.Endpoints;
import com.example.xpertgroupprueba.model.ImagesModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ImagesCall {
    private ImagesInterface imagesInterface;
    private static ImagesCall INSTANCE;

    public ImagesCall() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Endpoints.URL_BASE)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        imagesInterface = retrofit.create(ImagesInterface.class);
    }

    public static ImagesCall getINSTANCE() {
        if (null == INSTANCE){
            INSTANCE = new ImagesCall();
        }
        return INSTANCE;
    }

    public Call<List<ImagesModel>> getImages(){
        return imagesInterface.getImages();
    }
}
