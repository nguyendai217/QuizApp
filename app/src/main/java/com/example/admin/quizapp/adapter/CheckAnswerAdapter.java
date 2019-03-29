package com.example.admin.quizapp.adapter;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.example.admin.quizapp.R;
import com.example.admin.quizapp.model.Question;
import java.util.ArrayList;
public class CheckAnswerAdapter extends BaseAdapter {
    ArrayList listItem;
    LayoutInflater layoutInflater;
    Context context;
    public CheckAnswerAdapter(ArrayList listItem, Context context) {
        this.listItem = listItem;
        this.context=context;
        layoutInflater=LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return listItem.size();
    }
    @Override
    public Object getItem(int position) {
        return listItem.get(position);
    }
    @Override
    public long getItemId(int position) {
        return 0;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Question data= (Question) getItem(position);  // l?y v? trí c?a câu tr? l?i trên view
        ViewHolder viewHolder;
        if (convertView== null){
            viewHolder= new ViewHolder();
            convertView= layoutInflater.inflate(R.layout.item_answer, null);
            viewHolder.tvAnswer= convertView.findViewById(R.id.tv_Answer); // anh xa vi tri cua tv len view holder
            viewHolder.tvResult= convertView.findViewById(R.id.tv_Result);
            convertView.setTag(viewHolder);
        }
        else viewHolder= (ViewHolder) convertView.getTag();
        int i= position+1;
        viewHolder.tvAnswer.setText("Ans "+i+" :");
        viewHolder.tvResult.setText(data.getAnswer());
        return convertView;
    }
    private static class ViewHolder{
        TextView tvAnswer, tvResult;
    }

}
