package com.example.photogallery;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.List;

public class PhotoGallery extends AppCompatActivity {
    private final List<Photo> photos = new ArrayList<>();
    private final PhotoAdapter adapter = new PhotoAdapter(photos);
    private PhotosDAO dao;
    private final FlickrAPI flickrAPI = ServiceAPI.getRetrofit().create(FlickrAPI.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gallery_activity);
        dao = PhotosDB.getDatabase(getApplicationContext()).getPhotosDao();

        final RecyclerView recycler = findViewById(R.id.rView);
        recycler.setLayoutManager(new GridLayoutManager(this, 5));

        flickrAPI.getRecent().enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                photos.addAll(response.body().getPhotos().getPhoto());
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                AlertDialog alertDialog = new AlertDialog.Builder(PhotoGallery.this).create(); //Read Update
                alertDialog.setTitle("Info");
                alertDialog.setMessage("Something went wrong...");
                alertDialog.show();
            }
        });

        Intent intent = getIntent();
        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(SearchManager.QUERY);
            flickrAPI.searchPhotos(query).enqueue(new Callback<Example>() {
                @Override
                public void onResponse(Call<Example> call, Response<Example> response) {
                    photos.addAll(response.body().getPhotos().getPhoto());
                    adapter.notifyDataSetChanged();
                }

                @Override
                public void onFailure(Call<Example> call, Throwable t) {
                    AlertDialog alertDialog = new AlertDialog.Builder(PhotoGallery.this).create(); //Read Update
                    alertDialog.setTitle("Info");
                    alertDialog.setMessage("Something went wrong...");
                    alertDialog.show();
                }
            });
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);

        // Get the SearchView and set the searchable configuration
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView = (SearchView) menu.findItem(R.id.search_bar).getActionView();
        // Assumes current activity is the searchable activity
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setIconifiedByDefault(false); // Do not iconify the widget; expand it by defaul

        return true;
    }

}