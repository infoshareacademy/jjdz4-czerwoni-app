package com.infoshareacademy.czerwoni.question.ejb;

import com.infoshareacademy.czerwoni.question.domain.Answer;
import com.infoshareacademy.czerwoni.question.domain.Question;


import javax.ejb.Local;
import java.util.List;

@Local
public interface QuestionAnswerServiceLocal {
    void addQuestion(Question question);
    Question getQuestionById(int id);
    List<Answer> getAllAnswers();
    List<Question>getAllQuestions();
    Answer getAnswerById(int id);
    void addAnswer(Answer answer);
    void updateAnswer(Answer answer);
    List<Answer> getAnswersWithoutRelatedQuestion();
    void updateQuestion(Question question);
    void removeQuestion(Question question);
    void removeAnswer(Answer answer);
}
