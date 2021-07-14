package com.rymo.livedata;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.rymo.livedata.adapters.FavRvAdapter;
import com.rymo.livedata.database.AppDatabase;
import com.rymo.livedata.model.Favourites;
import com.rymo.livedata.view_model.FavouritesViewModel;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    AppDatabase db;
    RecyclerView recyclerView;
    List<Favourites> list = new ArrayList<>();
    FavouritesViewModel viewModel;
    FavRvAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = AppDatabase.getAppDatabase(this);
        viewModel = new FavouritesViewModel(db);

        recyclerView = findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new FavRvAdapter(this,list).setOnItemClickListener(new FavRvAdapter.OnItemClickListener() {
            @Override
            public void onDeleteClick(int position, Favourites favourites) {
                viewModel.removeFav(favourites);
            }
        });
        recyclerView.setAdapter(adapter);


        viewModel.getFaves().observe(this, new Observer<List<Favourites>>() {
            @Override
            public void onChanged(List<Favourites> favourites) {
                list.clear();
                list.addAll(favourites);
                adapter.notifyDataSetChanged();
            }
        });


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(v -> {
            Toast.makeText(this, "عنوان شماره " + (list.size() + 1) + " اضافه شد", Toast.LENGTH_SHORT).show();
            Favourites favourites = new Favourites();
            favourites.setTitle("عنوان شماره " + (list.size() + 1));
            viewModel.insertFav(favourites);
        });

    }
}