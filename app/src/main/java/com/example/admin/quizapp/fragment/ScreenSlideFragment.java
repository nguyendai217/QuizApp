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
import com.example.admin.quizapp.model.Question;
import java.util.ArrayList;

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
       tvNum= rootview.findViewById(R.id.tvNumber_question);
       tvQuestion= rootview.findViewById(R.id.tvQuestion);
       radA= rootview.findViewById(R.id.radA);
        radB= rootview.findViewById(R.id.radB);
        radC= rootview.findViewById(R.id.radC);
        radD= rootview.findViewById(R.id.radD);
        radioGroup= rootview.findViewById(R.id.radGroup);
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
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

       // Log.d("dai", "onActivityCreated: "+tvNum);
        tvQuestion.setText(arrQuestion.get(mPage).getContents());
        radA.setText(getItem(mPage).getAns_a());
        radB.setText(getItem(mPage).getAns_b());
        radC.setText(getItem(mPage).getAns_c());
        radD.setText(getItem(mPage).getAns_d());
        tvNum.setText("Câu "+ (mPage+1));

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

            }
        });
    }
    public static ScreenSlideFragment create(int pageNumber){
        ScreenSlideFragment screenFragment= new ScreenSlideFragment();
        Bundle bundle= new Bundle();
        bundle.putInt(PAGE,pageNumber);
        screenFragment.setArguments(bundle);
        return screenFragment;
    }
    public Question getItem(int posotion){
        return arrQuestion.get(posotion);
    }
}
