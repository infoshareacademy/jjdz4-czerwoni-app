package com.infoshareacademy.czerwoni.question.ejb;

import com.infoshareacademy.czerwoni.question.domain.Answer;
import com.infoshareacademy.czerwoni.question.domain.Question;
import com.infoshareacademy.czerwoni.question.repository.AnswerRepsitory;
import com.infoshareacademy.czerwoni.question.repository.QuestionRepository;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class QuestionAnswerService implements QuestionAnswerServiceLocal {
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
    @Override
    public List<Question> getAllQuestions(){
        return questionRepository.getAllQuestions();
    }
    @Override
    public Answer getAnswerById(int id){
        return answerRepsitory.getAnswerById(id);
    }
    @Override
    public void addAnswer(Answer answer){
        answerRepsitory.addAnswer(answer);
    }
    @Override
    public void updateAnswer(Answer answer){
        answerRepsitory.updateAnswer(answer);
    }
    @Override
    public List<Answer> getAnswersWithoutRelatedQuestion(){
        return answerRepsitory.getAnswersWithoutRelatedQuestions();
    }
    @Override
    public void updateQuestion(Question question){
        questionRepository.updateQuestion(question);
    }

    @Override
    public void removeQuestion(Question question) {
        questionRepository.removeQuestion(question);
    }

    @Override
    public void removeAnswer(Answer answer) {
        answerRepsitory.removeAnswer(answer);
    }


}
