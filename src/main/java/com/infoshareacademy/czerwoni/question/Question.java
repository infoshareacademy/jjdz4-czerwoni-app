package com.infoshareacademy.czerwoni.question;


import java.util.ArrayList;

/**
 * Klasa opisuje pytania z pliku XML
 */
public class Question {
    private int questionId;
    private String questionName;
    ArrayList<Answer> answerList = new ArrayList<>();

    public int getQuestionId() {
        return questionId;
    }

    void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getQuestionName() {
        return questionName;
    }

    void setQuestionName(String questionName) {
        this.questionName = questionName;
    }

    public ArrayList<Answer> getAnswerList() {
        return answerList;
    }

    public void setAnswerList(ArrayList<Answer> answerList) {
        this.answerList = answerList;
    }



}
