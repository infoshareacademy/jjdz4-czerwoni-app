package com.infoshareacademy.czerwoni.question.dao;

import com.infoshareacademy.czerwoni.question.domain.Category;
import com.infoshareacademy.czerwoni.question.repository.CategoryRepository;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class CategoryDaoBean implements CategoryDao{
    @Inject
    CategoryRepository categoryRepository;

    @Override
    public Category getCategoryById(int id){
        return categoryRepository.getCategoryById(id);
    }
    @Override
    public void addCategory(Category category){
        categoryRepository.addCategory(category);
    }
}
