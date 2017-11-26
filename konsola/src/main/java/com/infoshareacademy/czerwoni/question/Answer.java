package com.infoshareacademy.czerwoni.question;

/**
 * Klasa opisująca odpowiedzi do pytań
 */
public class Answer {

    private int answerId;
    private String answerName;
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
