package com.example.admin.quizapp.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.admin.quizapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ScreenSlideFragment extends Fragment {


    public ScreenSlideFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_screen_slide, container, false);
    }

}