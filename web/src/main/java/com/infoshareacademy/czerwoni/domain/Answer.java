package com.infoshareacademy.czerwoni.domain;

import javax.persistence.*;

/**
 * Klasa opisująca odpowiedzi do pytań
 */
@Entity
@NamedQueries({
        @NamedQuery(name = "selectAll", query = "from Answer")
})
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private int answerId;
    @Column(nullable = false)
    private String answerName;
    @OneToOne(orphanRemoval = true)
    private Question relatedQuest;

    public int getAnswerId() {
        return answerId;
    }

    void setAnswerId(int answerId) {
        this.answerId = answerId;
    }

    public String getAnswerName() {
        return answerName;
    }

    void setAnswerName(String answerName) {
        this.answerName = answerName;
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
