package com.infoshareacademy.czerwoni.question.repository;

import com.infoshareacademy.czerwoni.question.domain.Category;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class CategoryRepository {
    @PersistenceContext(unitName = "pUnit")
    EntityManager entityManager;

    public Category getCategoryById(int id){
        return entityManager.find(Category.class, id);
    }
    public void addCategory(Category category){
        entityManager.persist(category);
    }
    public void updateCategory(Category category){
        entityManager.merge(category);
    }
    public void removeCategory(Category category){
        entityManager.remove(entityManager.contains(category) ? category : entityManager.merge(category));
    }
}
