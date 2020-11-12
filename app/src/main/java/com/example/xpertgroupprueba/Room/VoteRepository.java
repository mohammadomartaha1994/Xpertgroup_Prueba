package com.example.xpertgroupprueba.Room;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.xpertgroupprueba.model.VoteModel;


import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;


import java.util.List;

public class VoteRepository {
    private VoteDao mVotesDao;
    private LiveData<List<VoteModel>> getAllvotes;
    private LiveData<VoteModel> getProductItem;
    public VoteRepository(Application app)
    {
        VoteRoomDb db = VoteRoomDb.getInstance(app);
        mVotesDao = db.voteDao();
        getAllvotes = mVotesDao.getAllProduct();
    }

    public void insert(VoteModel voteModel)
    {
        new InsertAsyncTask(mVotesDao).execute(voteModel);
    }

    public LiveData<List<VoteModel>> getAllvotes()
    {
        return getAllvotes;
    }

    private static class InsertAsyncTask extends AsyncTask<VoteModel, Void, Void>{
        private VoteDao mVotesDao;
        public InsertAsyncTask(VoteDao votesDao)
        {
            mVotesDao = votesDao;
        }
        @Override
        protected Void doInBackground(VoteModel... voteModels) {
            mVotesDao.insert(voteModels[0]);
            return null;
        }
    }
}
