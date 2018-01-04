package com.infoshareacademy.czerwoni.domain;


import org.hibernate.annotations.Proxy;

import javax.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Klasa opisuje pytania z pliku XML
 */
@Entity
@NamedQueries({
        @NamedQuery(name = "selectAllQuestions", query = "from Question ")
})
public class Question{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, unique = true)
    private int questionId;

    @Column
    private String questionName;
    private int questionLevel;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "question_id")
    private List<Answer> answerList = new ArrayList<>();

    public int getQuestionId() {
        return questionId;
    }
    void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getQuestionName() {
        return questionName;
    }

    public void setQuestionName(String questionName) {
        this.questionName = questionName;
    }


    public int getQuestionLevel() {
        return questionLevel;
    }

    public void setQuestionLevel(int questionLevel) {
        this.questionLevel = questionLevel;
    }

    public List<Answer> getAnswerList() {
        return answerList;
    }

    public void setAnswerList(List<Answer> answerList) {
        this.answerList = answerList;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Question) {
            Question other = (Question) o;
            return this.questionId == other.questionId;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.questionId;
    }
}
