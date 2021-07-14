package com.rymo.livedata.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "tbl_fav")
public class Favourites {

    @PrimaryKey(autoGenerate = true)
    public long id;
    public String title;

    public long getId() {
        return id;
    }

    public Favourites setId(long id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Favourites setTitle(String title) {
        this.title = title;
        return this;
    }
}
