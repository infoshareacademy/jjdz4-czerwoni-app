package com.infoshareacademy.czerwoni.dao;

import com.infoshareacademy.czerwoni.domain.Category;
import javax.ejb.Local;


@Local
public interface CategoryDao {
    Category getCategoryById(int id);
}
