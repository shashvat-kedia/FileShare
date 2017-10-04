package com.example.shashvatkedia.fileshare;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.GridView;

import java.util.ArrayList;

import static com.example.shashvatkedia.fileshare.sendActivity.grid;

/**
 * Created by Shashvat Kedia on 04-10-2017.
 */

public class PhotoRetrieveAsync extends AsyncTask<String,Void,ArrayList<PhotoData>> {
    Context context;
    ArrayList<PhotoData> photoData = new ArrayList<PhotoData>();
    public PhotoRetrieveAsync(Context con){
        super();
        context = con;
    }
    @Override
    protected ArrayList<PhotoData> doInBackground(String... urls) {
        String[] columns = { MediaStore.Images.Media.DATA, MediaStore.Images.Media._ID ,MediaStore.Images.Media.DATE_TAKEN};
        String orderBy = MediaStore.Images.Media.DATE_TAKEN;
        Cursor queryResult = context.getContentResolver().query(MediaStore.Images.Media.INTERNAL_CONTENT_URI,columns,null,null,orderBy);
        int image_column_index = queryResult.getColumnIndex(MediaStore.Images.Media._ID);
        int count = queryResult.getCount();
        for(int i=0;i<count;i++){
            queryResult.moveToPosition(i);
            int id = queryResult.getInt(image_column_index);
            int data_column_index = queryResult.getColumnIndex(MediaStore.Images.Media.DATA);
            Bitmap thumbnail = MediaStore.Images.Thumbnails.getThumbnail(context.getApplicationContext().getContentResolver(),
                    id,MediaStore.Images.Thumbnails.MICRO_KIND, null);
            String path = queryResult.getString(data_column_index);
            PhotoData phData = new PhotoData(thumbnail,path);
            photoData.add(phData);
    }
    return photoData;
}
    @Override
    protected void onPostExecute(ArrayList<PhotoData> photoData) {
        if (photoData != null) {
            PhotosRecycler recycle = new PhotosRecycler(context.getApplicationContext(),photoData);
            sendActivity.grid.setAdapter(recycle);
        }
    }
}
