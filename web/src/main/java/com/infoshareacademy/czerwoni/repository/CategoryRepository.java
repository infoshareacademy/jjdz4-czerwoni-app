package com.infoshareacademy.czerwoni.repository;

import com.infoshareacademy.czerwoni.domain.Category;

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
}
