package com.example.shashvatkedia.fileshare;

import android.graphics.Bitmap;

/**
 * Created by Shashvat Kedia on 03-10-2017.
 */

public class PhotoData {
    private Bitmap thumbnail;
    private String path;

    public PhotoData(Bitmap nail, String imagePath){
        thumbnail = nail;
        path = imagePath;
    }

    public Bitmap getThumbnail(){
        return this.thumbnail;
    }

    public String getPath(){
        return this.path;
    }
}
