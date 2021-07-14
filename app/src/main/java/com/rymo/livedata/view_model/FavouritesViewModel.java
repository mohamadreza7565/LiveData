package com.rymo.livedata.view_model;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.rymo.livedata.dao.FavDao;
import com.rymo.livedata.database.AppDatabase;
import com.rymo.livedata.model.Favourites;

import java.util.ArrayList;
import java.util.List;

public class FavouritesViewModel extends ViewModel {

    AppDatabase db;
    FavDao favDao;

    public FavouritesViewModel(AppDatabase db) {
        this.db = db;
    }

    MutableLiveData<List<Favourites>> mutableLiveData = new MutableLiveData<>();

    public MutableLiveData<List<Favourites>> getFaves() {
        FavDao favDao = db.getFavDao();
        List<Favourites> list = new ArrayList<>();
        list = favDao.getAll();
        mutableLiveData.setValue(list);
        return mutableLiveData;
    }

    public void insertFav(Favourites favourites) {
        FavDao favDao = db.getFavDao();
        favDao.insert(favourites);
        List<Favourites> list = new ArrayList<>();
        list = favDao.getAll();
        mutableLiveData.setValue(list);
    }

    public void removeFav(Favourites favourites) {
        FavDao favDao = db.getFavDao();
        favDao.delete(favourites);
        List<Favourites> list = new ArrayList<>();
        list = favDao.getAll();
        mutableLiveData.setValue(list);
    }


}
