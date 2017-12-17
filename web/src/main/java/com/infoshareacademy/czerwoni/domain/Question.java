package com.infoshareacademy.czerwoni.domain;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Klasa opisuje pytania z pliku XML
 */
@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int questionId;
    @Column
    private String questionName;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "Question")
    @JoinColumn(name = "question_id")
    List<Answer> answerList = new ArrayList<>();

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

    public List<Answer> getAnswerList() {
        return answerList;
    }

    public void setAnswerList(ArrayList<Answer> answerList) {
        this.answerList = answerList;
    }



}
