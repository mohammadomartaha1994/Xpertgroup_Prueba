package com.example.xpertgroupprueba.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class VoteModel {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String uRLImageVote;
    private String dateVote;
    private String imageidentifier;


    public VoteModel(String uRLImageVote, String dateVote, String imageidentifier) {
        this.uRLImageVote = uRLImageVote;
        this.dateVote = dateVote;
        this.imageidentifier = imageidentifier;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String uRLImageVote() {
        return uRLImageVote;
    }

    public String dateVote() {
        return dateVote;
    }

    public String imageidentifier() {
        return imageidentifier;
    }

}
