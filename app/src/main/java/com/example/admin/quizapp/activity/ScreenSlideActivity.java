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

import com.example.admin.quizapp.R;
import com.example.admin.quizapp.fragment.ScreenSlideFragment;
import com.example.admin.quizapp.question.Question;
import com.example.admin.quizapp.question.QuestionController;

import java.util.ArrayList;

public class ScreenSlideActivity extends FragmentActivity {
    private static final int NUM_PAGES = 10;
    private ViewPager viewPager;
    private PagerAdapter pagerAdapter;

    QuestionController questionController;
    ArrayList<Question>arrQuestion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_slide);
        init();
        controls();
    }

    private void controls() {
        pagerAdapter = new ScreenSlideAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);
        viewPager.setPageTransformer(true, new DepthPageTransformer());// setup hiệu ứng cho viewpager
        questionController= new QuestionController(this);
        arrQuestion= new ArrayList<>();
        arrQuestion= questionController.getQuestion(1,"math");


    }
    public  ArrayList<Question> getData(){
        return  arrQuestion;

    }

    private void init() {
        viewPager = findViewById(R.id.vwpager);
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
        private static float MIN_SCALE = 0.75f;

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
