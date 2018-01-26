package com.infoshareacademy.czerwoni.allegro.dao;

import com.infoshareacademy.czerwoni.allegro.AllegroCategory;

import java.util.List;
import java.util.Map;

public interface CategoriesService {
    Map<AllegroCategory, String> getCategories(int parentId);
    AllegroCategory getMainCategory(int catId);
    List<AllegroCategory> getBreadCrumbs(int catId);
    AllegroCategory getParentCat(int id);
    AllegroCategory getCategoryById(int id);
}