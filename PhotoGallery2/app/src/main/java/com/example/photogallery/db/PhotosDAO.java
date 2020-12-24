package com.example.photogallery.db;


@Dao
public interface PhotosDAO {
    @Query("SELECT * FROM Photo")
    List<Photo> loadAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertPhoto(Photo photo);

    @Delete
    void deletePhoto(Photo photo);

}
