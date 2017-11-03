package com.infoshareacademy.czerwoni;

/**
 * Klasa opisująca odpowiedzi do pytań
 */
class Answer {

    private int answerId;
    private String answerName;
    private int relatedQuest;

    int getAnswerId() {
        return answerId;
    }

    void setAnswerId(int answerId) {
        this.answerId = answerId;
    }

    String getAnswerName() {
        return answerName;
    }

    void setAnswerName(String answerName) {
        this.answerName = answerName;
    }

    int getRelatedQuest() {
        return relatedQuest;
    }

    void setRelatedQuest(int relatedQuest) {
        this.relatedQuest = relatedQuest;
    }
}
