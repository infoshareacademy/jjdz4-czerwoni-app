package com.infoshareacademy.czerwoni.repository;

import com.infoshareacademy.czerwoni.domain.Answer;

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
}
