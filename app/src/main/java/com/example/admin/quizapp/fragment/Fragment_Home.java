package com.example.admin.quizapp.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.admin.quizapp.R;
import com.example.admin.quizapp.activity.MainActivity;
import com.example.admin.quizapp.activity.ScreenSlideActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_Home extends Fragment implements View.OnClickListener{
    ImageView imgMath,imgChemistry,imgPhysics;



    public Fragment_Home() {

        // Required empty public constructor
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        init();
        controls();
    }

    private void init() {
        imgMath=getActivity().findViewById(R.id.img_math);
        imgChemistry=getActivity().findViewById(R.id.img_chemistry);
        imgPhysics=getActivity().findViewById(R.id.img_physics);
    }

    private void controls() {
        imgMath.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getActivity(),ScreenSlideActivity.class);
                startActivity(intent);
            }
        });
        imgPhysics.setOnClickListener(this);
        imgChemistry.setOnClickListener(this);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //getActivity().getActionBar().setTitle("Trang Chủ");
        return inflater.inflate(R.layout.fragment_home, container, false);
    }


    @Override
    public void onClick(View v) {

    }
}
