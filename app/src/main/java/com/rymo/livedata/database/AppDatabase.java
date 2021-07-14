package com.rymo.livedata.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.rymo.livedata.dao.FavDao;
import com.rymo.livedata.model.Favourites;

@Database(version = 1, exportSchema = false, entities = {Favourites.class})
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase appDatabase;

    public static AppDatabase getAppDatabase(Context context) {
        if (appDatabase == null)
            appDatabase = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "db_app")
                    .allowMainThreadQueries()
                    .build();

        return appDatabase;
    }

    public abstract FavDao getFavDao();

}
