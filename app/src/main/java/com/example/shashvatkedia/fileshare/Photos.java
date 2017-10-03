package com.example.shashvatkedia.fileshare;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import static android.R.attr.data;

/**
 * Created by Shashvat Kedia on 03-10-2017.
 */

public class Photos extends Fragment {
    public static ViewGroup contain;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        Intent inte = new Intent(getContext(),RetrievePhotos.class);
        contain = container;
        startActivity(inte);
        return null;
    }

}
