package com.infoshareacademy.czerwoni.dao;

import com.infoshareacademy.czerwoni.domain.Category;
import com.infoshareacademy.czerwoni.repository.CategoryRepository;

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
}
