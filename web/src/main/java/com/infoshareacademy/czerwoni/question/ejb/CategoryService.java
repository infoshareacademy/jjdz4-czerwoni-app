package com.infoshareacademy.czerwoni.question.ejb;

import com.infoshareacademy.czerwoni.question.domain.Category;
import com.infoshareacademy.czerwoni.question.repository.CategoryRepository;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class CategoryService implements CategoryServiceLocal {
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
    @Override
    public void removeCategory(Category category){
        categoryRepository.removeCategory(category);
    }

    @Override
    public void updateCategory(Category category) {
        categoryRepository.updateCategory(category);
    }

}
