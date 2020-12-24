package com.example.photogallery;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public
class PhotoGallery extends AppCompatActivity {

    private final PhotoAdapter adapter = new PhotoAdapter(photos);

    @Override
    protected
    void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gallery_activity);

        final RecyclerView recycler = findViewById(R.id.rView);
        recycler.setLayoutManager(new GridLayoutManager(this, 3));
    }
}