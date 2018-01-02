package com.infoshareacademy.czerwoni.dao;

import com.infoshareacademy.czerwoni.domain.Answer;
import com.infoshareacademy.czerwoni.domain.Question;
import com.infoshareacademy.czerwoni.repository.AnswerRepsitory;
import com.infoshareacademy.czerwoni.repository.QuestionRepository;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class QuestionAnswerDaoBean implements QuestionAnswerDao {
    @EJB
    QuestionRepository questionRepository;

    @EJB
    AnswerRepsitory answerRepsitory;

    @Override
    public void addQuestion(Question question){
        questionRepository.addQuestion(question);
    }

    @Override
    public Question getQuestionById(int id){
        return questionRepository.getQuestionById(id);
    }
    @Override
    public List<Answer> getAllAnswers(){
        return answerRepsitory.getAllAnswers();
    }


}
