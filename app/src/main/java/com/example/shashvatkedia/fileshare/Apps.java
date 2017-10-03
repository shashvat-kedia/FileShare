package com.example.shashvatkedia.fileshare;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Shashvat Kedia on 03-10-2017.
 */

public class Apps extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstaneState){
        return inflater.inflate(R.layout.fragment_apps,container,false);
    }
}
