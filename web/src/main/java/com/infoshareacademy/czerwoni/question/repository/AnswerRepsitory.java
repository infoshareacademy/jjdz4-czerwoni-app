package com.infoshareacademy.czerwoni.question.repository;

import com.infoshareacademy.czerwoni.question.domain.Answer;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class AnswerRepsitory {
    @PersistenceContext(unitName = "pUnit")
    EntityManager entityManager;

    public void addAnswer(Answer answer){
        entityManager.persist(answer);
    }

    public void updateAnswer(Answer answer){
        entityManager.merge(answer);
    }

    public List<Answer> getAllAnswers(){
        return entityManager.createNamedQuery("selectAllAnswers").getResultList();
    }

    public Answer getAnswerById(int id){
        return entityManager.find(Answer.class, id);
    }

    public List<Answer> getAnswersWithoutRelatedQuestions(){
        return entityManager.createNamedQuery("selectWithoutRelatedQuest").getResultList();
    }
    public void removeAnswer(Answer answer){
        entityManager.remove(entityManager.contains(answer) ? answer : entityManager.merge(answer));
    }
}
