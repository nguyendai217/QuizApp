package com.example.admin.quizapp.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.admin.quizapp.R;
import com.example.admin.quizapp.activity.ScreenSlideActivity;
import com.example.admin.quizapp.question.Question;

import java.util.ArrayList;
import java.util.Queue;

/**
 * A simple {@link Fragment} subclass.
 */
public class ScreenSlideFragment extends Fragment {
    ArrayList<Question> arrQuestion;
    public static final String PAGE= "page";
    private int mPage;
    TextView tvNum , tvQuestion;
    RadioGroup radioGroup;
    RadioButton radA, radB, radC,radD;




    public ScreenSlideFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootview= (ViewGroup) inflater.inflate(R.layout.fragment_screen_slide,container,false);
        // Inflate the layout for this fragment
        init();
        return rootview;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        arrQuestion= new ArrayList<>();
        ScreenSlideActivity screenSlide= (ScreenSlideActivity) getActivity();
        arrQuestion= screenSlide.getData();

        mPage= getArguments().getInt(PAGE);

    }

    private void init() {
        tvNum= getActivity().findViewById(R.id.tvNum);
        tvQuestion=getActivity().findViewById(R.id.tvQuestion);
        radA= getActivity().findViewById(R.id.radA);
        radB= getActivity().findViewById(R.id.radB);
        radC= getActivity().findViewById(R.id.radC);
        radD= getActivity().findViewById(R.id.radD);
        radioGroup= getActivity().findViewById(R.id.radGroup);
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        tvNum.setText("câu"+mPage);
        tvQuestion.setText(arrQuestion.get(mPage).getContent());
        radA.setText(arrQuestion.get(mPage).getAns_a());
        radB.setText(arrQuestion.get(mPage).getAns_b());
        radC.setText(arrQuestion.get(mPage).getAns_c());
        radD.setText(arrQuestion.get(mPage).getAns_d());

    }
    public static ScreenSlideFragment create(int pageNumber){
        ScreenSlideFragment screenFragment= new ScreenSlideFragment();
        Bundle bundle= new Bundle();
        bundle.putInt(PAGE,pageNumber);
        screenFragment.setArguments(bundle);
        return screenFragment;
    }

}
