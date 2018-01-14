package com.infoshareacademy.czerwoni.question.dao;

import com.infoshareacademy.czerwoni.question.domain.Category;
import javax.ejb.Local;


@Local
public interface CategoryDao {
    Category getCategoryById(int id);
    void addCategory(Category category);
}
