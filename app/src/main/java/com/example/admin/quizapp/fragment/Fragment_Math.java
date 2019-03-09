package com.example.admin.quizapp.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.admin.quizapp.R;
import com.example.admin.quizapp.activity.ScreenSlideActivity;
import com.example.admin.quizapp.adapter.ExamAdapter;
import com.example.admin.quizapp.model.Exam;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_Math extends Fragment implements onBackPressListener {
    GridView gridViewExam;
    ExamAdapter examAdapter;
    ArrayList<Exam> arrayListExam = new ArrayList<>();

    public Fragment_Math() {
        // Required empty public constructor
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        gridViewExam = getActivity().findViewById(R.id.gvExam);
        for (int i =1; i <8 ; i++) {
            arrayListExam.add(new Exam("Đề thi số "+i));

        }
        examAdapter = new ExamAdapter(getActivity(), arrayListExam);
        gridViewExam.setAdapter(examAdapter);
        gridViewExam.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), ScreenSlideActivity.class);
                startActivity(intent);
            }
        });

    }
    @Override
    public void onBackPressed() {

        int count =getFragmentManager().getBackStackEntryCount();

        if (count == 0) {

            //additional code
        } else {
            getFragmentManager().popBackStack();
        }

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        // getActivity().getActionBar().setTitle("Môn Toán");
        return inflater.inflate(R.layout.fragment_math, container, false);
    }


}
