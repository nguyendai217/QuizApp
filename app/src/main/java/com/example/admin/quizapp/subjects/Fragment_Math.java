package com.example.admin.quizapp.subjects;


import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.admin.quizapp.R;
import com.example.admin.quizapp.activity.ScreenSlideActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_Math extends Fragment {
    ActionBar actionBar;
    Button btnStart;


    public Fragment_Math() {
        // Required empty public constructor
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        init();
        controls();
    }

    private void controls() {
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ScreenSlideActivity.class);
                startActivity(intent);
            }
        });
    }

    private void init() {
        btnStart = getActivity().findViewById(R.id.btnStart);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        // getActivity().getActionBar().setTitle("Môn Toán");
        return inflater.inflate(R.layout.fragment_math, container, false);
    }

}
