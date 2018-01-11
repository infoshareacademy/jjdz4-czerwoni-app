package com.infoshareacademy.czerwoni.dao;

import com.infoshareacademy.czerwoni.domain.Answer;
import com.infoshareacademy.czerwoni.domain.Question;
import com.infoshareacademy.czerwoni.repository.QuestionRepository;


import javax.ejb.Local;
import java.util.List;

@Local
public interface QuestionAnswerDao {
    void addQuestion(Question question);
    Question getQuestionById(int id);
    List<Answer> getAllAnswers();
    List<Question>getAllQuestions();
    Answer getAnswerById(int id);
    void addAnswer(Answer answer);
    void updateAnswer(Answer answer);



}
