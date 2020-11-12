package com.example.xpertgroupprueba.Room;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.xpertgroupprueba.model.VoteModel;

import java.util.List;

@Dao
public interface VoteDao {
    @Insert
    void insert(VoteModel voteModel);

    @Query("SELECT * From VoteModel ORDER BY id DESC ")
    LiveData<List<VoteModel>> getAllProduct();
}