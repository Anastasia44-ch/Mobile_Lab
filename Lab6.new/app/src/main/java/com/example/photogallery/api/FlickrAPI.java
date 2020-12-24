package com.example.photogallery.api;

import com.example.photogallery.model.Example;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface FlickrAPI {
    @GET("services/rest/?method=flickr.photos.getRecent&api_key=24b9a92aebad255fd288b6feb67ab269&extras=url_s&format=json&nojsoncallback=1")
    Call<Example> getRecent();

    @GET("services/rest/?method=flickr.photos.search&api_key=24b9a92aebad255fd288b6feb67ab269&extras=url_s&format=json&nojsoncallback=1")
    Call<Example> searchPhotos(@Query("text") String keyWord);
}