package com.example.xpertgroupprueba.model_view;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;


import com.example.xpertgroupprueba.Room.VoteRepository;
import com.example.xpertgroupprueba.model.VoteModel;

import java.util.List;

public class VoteViewModel extends AndroidViewModel {
    private VoteRepository mRepository;
    private LiveData<List<VoteModel>> mAllvotes;
    public VoteViewModel(@NonNull Application application) {
        super(application);
        mRepository = new VoteRepository(application);
        mAllvotes = mRepository.getAllvotes();
    }
    public void insert(VoteModel voteModel) {
        mRepository.insert(voteModel);
    }
    public LiveData<List<VoteModel>> getAllvotes() {
        return mAllvotes;
    }
}
