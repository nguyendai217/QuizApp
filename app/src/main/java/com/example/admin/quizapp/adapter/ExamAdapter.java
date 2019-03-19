package com.example.admin.quizapp.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.admin.quizapp.R;
import com.example.admin.quizapp.model.Exam;
import java.util.ArrayList;


public class ExamAdapter extends ArrayAdapter<Exam> {
    public ExamAdapter( Context context, ArrayList<Exam> arrayExam) {
        super(context, 0, arrayExam);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater layoutInflater = LayoutInflater.from(getContext());
            convertView = layoutInflater.inflate(R.layout.item_gridview, parent, false);
        }
        TextView tvNumberExam = convertView.findViewById(R.id.tv_NumberExam);
        ImageView imgExam = convertView.findViewById(R.id.img_Exam);

        Exam exam = getItem(position);
        if (exam != null) {
            tvNumberExam.setText("" + exam.getName());
            imgExam.setImageResource(R.drawable.icon_book);
        }
        return convertView;
    }
}
