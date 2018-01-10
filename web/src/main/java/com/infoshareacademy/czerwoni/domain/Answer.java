package com.infoshareacademy.czerwoni.domain;

import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Klasa opisująca odpowiedzi do pytań
 */
@Entity
@NamedQueries({
        @NamedQuery(name = "selectAllAnswers", query = "from Answer")
})
public class Answer implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private int answerId;
    @Column(nullable = false)
    private String answerName;
    @OneToOne
    private Category relatedCategory;
    @OneToOne(fetch = FetchType.LAZY,optional = false)
    private Question relatedQuest;


    public int getAnswerId() {
        return answerId;
    }

    public void setAnswerId(int answerId) {
        this.answerId = answerId;
    }

    public String getAnswerName() {
        return answerName;
    }

    public void setAnswerName(String answerName) {
        this.answerName = answerName;
    }

    public Category getRelatedCategory() {
        return relatedCategory;
    }

    public void setRelatedCategory(Category relatedCategory) {
        this.relatedCategory = relatedCategory;
    }


    public Question getRelatedQuest() {
        return relatedQuest;
    }

    public void setRelatedQuest(Question relatedQuest) {
        this.relatedQuest = relatedQuest;
    }
    @Override
    public boolean equals(Object o) {
        if (o instanceof Answer) {
            Answer other = (Answer) o;
            return this.answerId == other.answerId;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.answerId;
    }
}
