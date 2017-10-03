package com.example.shashvatkedia.fileshare;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Movie;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import static android.os.Build.VERSION_CODES.M;

/**
 * Created by Shashvat Kedia on 03-10-2017.
 */

public class RetrievePhotos extends Activity {
    private int count;
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        sendActivity.thumbnails.clear();
        sendActivity.path.clear();
        String[] columns = { MediaStore.Images.Media.DATA, MediaStore.Images.Media._ID ,MediaStore.Images.Media.DATE_TAKEN};
        String orderBy = MediaStore.Images.Media.DATE_TAKEN;
        Cursor queryResult = getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,columns,null,null,orderBy);
        int image_column_index = queryResult.getColumnIndex(MediaStore.Images.Media._ID);
        count = queryResult.getCount();
        for(int i=0;i<count;i++){
            queryResult.moveToPosition(i);
            int id = queryResult.getInt(image_column_index);
            int data_column_index = queryResult.getColumnIndex(MediaStore.Images.Media.DATA);
            sendActivity.thumbnails.add(MediaStore.Images.Thumbnails.getThumbnail(getApplicationContext().getContentResolver(),
                    id,MediaStore.Images.Thumbnails.MICRO_KIND, null));
            sendActivity.path.add(queryResult.getString(data_column_index));
        }
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View convertView = inflater.inflate(R.layout.fragment_photos,Photos.contain,false);
        PhotosRecycler recycle = new PhotosRecycler(getApplicationContext());
        GridView grid = (GridView) convertView.findViewById(R.id.imagesGridView);
        grid.setAdapter(recycle);
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });
    }
}
