package com.example.admin.quizapp.question;

public class Question {
    private int id;
    private String content;
    private String ans_a;
    private String ans_b;
    private String ans_c;
    private String ans_d;
    private String result;
    private String subject;
    private String image;
    private int number_subject;

    public Question(int id, String content, String ans_a, String ans_b, String ans_c, String ans_d, String result, String subject, String image, int number_subject) {
        this.id = id;
        this.content = content;
        this.ans_a = ans_a;
        this.ans_b = ans_b;
        this.ans_c = ans_c;
        this.ans_d = ans_d;
        this.result = result;
        this.subject = subject;
        this.image = image;
        this.number_subject = number_subject;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAns_a() {
        return ans_a;
    }

    public void setAns_a(String ans_a) {
        this.ans_a = ans_a;
    }

    public String getAns_b() {
        return ans_b;
    }

    public void setAns_b(String ans_b) {
        this.ans_b = ans_b;
    }

    public String getAns_c() {
        return ans_c;
    }

    public void setAns_c(String ans_c) {
        this.ans_c = ans_c;
    }

    public String getAns_d() {
        return ans_d;
    }

    public void setAns_d(String ans_d) {
        this.ans_d = ans_d;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getNumber_subject() {
        return number_subject;
    }

    public void setNumber_subject(int number_subject) {
        this.number_subject = number_subject;
    }

    public Question() {
    }
}
