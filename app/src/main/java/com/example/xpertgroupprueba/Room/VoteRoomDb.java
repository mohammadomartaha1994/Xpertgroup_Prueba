package com.example.xpertgroupprueba.Room;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.xpertgroupprueba.model.VoteModel;


@Database(entities = VoteModel.class, version = 3)
public abstract class VoteRoomDb extends RoomDatabase {
    private static VoteRoomDb instance;
    public abstract VoteDao voteDao();
    public static synchronized VoteRoomDb getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    VoteRoomDb.class, "Vote_Databa1")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallBack)
                    .build();
        }
        return instance;
    }
    private static RoomDatabase.Callback roomCallBack = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
        }
    };
}
