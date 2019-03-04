package com.example.admin.quizapp.subjects;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.admin.quizapp.R;

public class Fragment_Physics extends Fragment {

    public Fragment_Physics() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       // getActivity().getActionBar().setTitle("Môn Vật Lý");
        return inflater.inflate(R.layout.fragment_physics, container, false);
    }



}
