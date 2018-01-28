package com.infoshareacademy.czerwoni.question.ejb;

import com.infoshareacademy.czerwoni.question.domain.Category;

import javax.ejb.Local;


@Local
public interface CategoryServiceLocal {
    Category getCategoryById(int id);
    void addCategory(Category category);
    void removeCategory(Category category);
    void updateCategory(Category category);
}
