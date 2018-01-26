package com.infoshareacademy.czerwoni.allegro.dao;

import com.infoshareacademy.czerwoni.allegro.AllegroCategory;

import java.util.List;

public interface DataPromoService {
    void addCategory(AllegroCategory allegroCategory);
    AllegroCategory getPromotedCategoryById(int Id);
    List<Integer> getAllPromotedCategories();
    void removeCategory(AllegroCategory allegroCategory);
    void setPromotedCategories(List<AllegroCategory> categories);
}
