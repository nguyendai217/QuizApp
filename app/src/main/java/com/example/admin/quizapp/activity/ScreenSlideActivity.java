package com.example.admin.quizapp.activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

import com.example.admin.quizapp.R;
import com.example.admin.quizapp.adapter.CheckAnswerAdapter;
import com.example.admin.quizapp.fragment.ScreenSlideFragment;
import com.example.admin.quizapp.model.Question;
import com.example.admin.quizapp.question.QuestionController;
import java.util.ArrayList;
public class ScreenSlideActivity extends FragmentActivity {
    private static final int NUM_PAGES = 10;
    private ViewPager viewPager;
    private PagerAdapter pagerAdapter;
    private TextView tvKiemTra;
    Button btnCancel,btnFinish;
    QuestionController questionController;
    ArrayList<Question>arrQuestion= new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_slide);
        init();
        addcontrols();
    }
    private void addcontrols() {
        pagerAdapter = new ScreenSlideAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);
        viewPager.setPageTransformer(true, new DepthPageTransformer());// setup hiệu ứng cho viewpager
        tvKiemTra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer();
            }
        });
    }
    public  ArrayList<Question> getData(){
        questionController= new QuestionController(this);
        arrQuestion = questionController.getQuestion(1,"english");
        return  arrQuestion;
    }
    private void init() {
        viewPager = findViewById(R.id.vwpager);
        tvKiemTra=findViewById(R.id.tvKiemTra);
    }

    private class ScreenSlideAdapter extends FragmentStatePagerAdapter {

        public ScreenSlideAdapter(FragmentManager fm) {
            super(fm);
        }
        @Override
        public Fragment getItem(int i) {
            return ScreenSlideFragment.create(i);
        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }
    }
    public void checkAnswer(){
        final Dialog dialog= new Dialog(this);
        dialog.setContentView(R.layout.checkanswer_dialog);
        CheckAnswerAdapter checkAnswerAdapter= new CheckAnswerAdapter(arrQuestion,this);
        GridView gridViewAnswer= dialog.findViewById(R.id.gridview_answer);
        gridViewAnswer.setAdapter(checkAnswerAdapter);

        gridViewAnswer.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                viewPager.setCurrentItem(position);
                dialog.dismiss();
            }
        });
        btnCancel=dialog.findViewById(R.id.btnCancel);
        btnFinish=dialog.findViewById(R.id.btnFinish);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        dialog.show();

    }
    @Override
    public void onBackPressed() {
        if (viewPager.getCurrentItem()== 0 ) {
            super.onBackPressed();

        } else {
            viewPager.setCurrentItem(viewPager.getCurrentItem());
            Dialog dialog = new Dialog(ScreenSlideActivity.this);
            showAlertDialog();
        }
    }
    public void showAlertDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Thông Báo");
        builder.setMessage("Bạn có muốn thoát bài kiểm tra hay không?");
        builder.setCancelable(false);
        builder.setPositiveButton("Không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        builder.setNegativeButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();

    }
    public static class DepthPageTransformer implements ViewPager.PageTransformer {
        private static float MIN_SCALE = 0.5f;

        public void transformPage(View view, float position) {
            int pageWidth = view.getWidth();

            if (position < -1) { // [-Infinity,-1)
                // This page is way off-screen to the left.
                view.setAlpha(0);

            } else if (position <= 0) { // [-1,0]
                // Use the default slide transition when moving to the left page
                view.setAlpha(1);
                view.setTranslationX(0);
                view.setScaleX(1);
                view.setScaleY(1);

            } else if (position <= 1) { // (0,1]
                // Fade the page out.
                view.setAlpha(1 - position);

                // Counteract the default slide transition
                view.setTranslationX(pageWidth * -position);

                // Scale the page down (between MIN_SCALE and 1)
                float scaleFactor = MIN_SCALE
                        + (1 - MIN_SCALE) * (1 - Math.abs(position));
                view.setScaleX(scaleFactor);
                view.setScaleY(scaleFactor);

            } else { // (1,+Infinity]
                // This page is way off-screen to the right.
                view.setAlpha(0);
            }
        }
    }
}
