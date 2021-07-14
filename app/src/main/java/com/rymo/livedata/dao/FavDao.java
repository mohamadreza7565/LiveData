package com.rymo.livedata.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.rymo.livedata.model.Favourites;

import java.util.List;

@Dao
public interface FavDao {

    @Query("SELECT * FROM tbl_fav")
    List<Favourites> getAll();

    @Insert
    long insert(Favourites favourites);

    @Delete
    void delete(Favourites favourites);

}
