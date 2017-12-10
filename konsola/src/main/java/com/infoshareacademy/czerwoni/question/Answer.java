package com.infoshareacademy.czerwoni.question;

import javax.persistence.*;

/**
 * Klasa opisująca odpowiedzi do pytań
 */
@Entity
@Table(name = "Answer")
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int answerId;
    @Column
    private String answerName;
    @ManyToOne
    @JoinColumn(name = "Question", nullable = false)
    private int relatedQuest;

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

    public int getRelatedQuest() {
        return relatedQuest;
    }

    void setRelatedQuest(int relatedQuest) {
        this.relatedQuest = relatedQuest;
    }
}
