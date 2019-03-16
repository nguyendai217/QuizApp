package com.example.admin.quizapp.question;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
public class QuestionController {
    private DBHelper dbHelper;

    public QuestionController(Context context) {
        dbHelper = new DBHelper(context);
    }

    public ArrayList<Question> getQuestion(int number_exam, String monhoc) {
        ArrayList<Question> arrayList = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT *FROM ExamEnglish WHERE number_exam = '"+number_exam+"' AND monhoc = '"+monhoc+"'", null);
        cursor.moveToFirst();
        do {
            Question question = new Question(cursor.getInt(0),
                    cursor.getString(1), cursor.getString(2),
                    cursor.getString(3), cursor.getString(4),
                    cursor.getString(5), cursor.getString(6),
                    cursor.getString(7), cursor.getInt(8),
                    cursor.getString(9));
            arrayList.add(question);
        }
        while (cursor.moveToNext()) ;
        return arrayList;
    }
}

