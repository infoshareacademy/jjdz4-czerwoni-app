package com.infoshareacademy.czerwoni;


import java.util.ArrayList;

/**
 * Klasa opisuje pytania z pliku XML
 */
class Question {
    private int questionId;
    private String questionName;
    ArrayList<Answer> answerList = new ArrayList<>();

    int getQuestionId() {
        return questionId;
    }

    void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    String getQuestionName() {
        return questionName;
    }

    void setQuestionName(String questionName) {
        this.questionName = questionName;
    }

    ArrayList<Answer> getAnswerList() {
        return answerList;
    }

    void setAnswerList(ArrayList<Answer> answerList) {
        this.answerList = answerList;
    }



}
