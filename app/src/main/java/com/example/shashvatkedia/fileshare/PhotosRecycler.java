package com.example.shashvatkedia.fileshare;

import android.content.Context;
import android.provider.ContactsContract;
import android.support.v4.view.LayoutInflaterCompat;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;

import static com.example.shashvatkedia.fileshare.sendActivity.thumbnails;

/**
 * Created by Shashvat Kedia on 03-10-2017.
 */

public class PhotosRecycler extends BaseAdapter {
    public Context context;
    public LayoutInflater inflater;

    class ViewHolder {
        ImageView photoImageView;
        ImageView tickImageView;
        int id;
    }

    public PhotosRecycler(Context con) {
         super();
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        context = con;
    }

    @Override
    public int getCount() {
        return thumbnails.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
       final ViewHolder holder;
        if(convertView == null){
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.custom_photos_grid_element,null);
            holder.tickImageView = (ImageView) convertView.findViewById(R.id.tickImageView);
            holder.photoImageView = (ImageView) convertView.findViewById(R.id.photoImageView);
            convertView.setTag(holder);
        }
        else{
            holder = (ViewHolder) convertView.getTag();
        }
        holder.photoImageView.setImageBitmap(sendActivity.thumbnails.get(position));
        holder.id = position;
        return convertView;
    }
}
