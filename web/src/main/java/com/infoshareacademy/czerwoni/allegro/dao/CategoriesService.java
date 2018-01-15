package com.infoshareacademy.czerwoni.allegro.dao;

import com.infoshareacademy.czerwoni.allegro.AllegroCategory;

import java.util.Map;

public interface CategoriesService {
    Map<AllegroCategory, String> getCategories(int parentId);
}