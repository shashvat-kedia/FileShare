package com.example.shashvatkedia.fileshare;

import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import static com.example.shashvatkedia.fileshare.sendActivity.photos;

/**
 * Created by Shashvat Kedia on 03-10-2017.
 */

public class PageAdapter extends FragmentStatePagerAdapter {
    private int noOfTabs;


    public PageAdapter(FragmentManager fragManager,int noTabs){
        super(fragManager);
        noOfTabs = noTabs;
    }

    @Override
    public Fragment getItem(int position){
        switch(position){
            case 0:
                Files files = new Files();
                return files;

            case 1:
                Videos videos = new Videos();
                return videos;

            case 2:
                Apps apps = new Apps();
                return apps;

            case 3:
                sendActivity.photos = new Photos();
                return photos;

            case 4:
                Music music = new Music();
                return music;

            default:
                return null;
        }
    }

    @Override
    public int getCount(){
        return noOfTabs;
    }
}
