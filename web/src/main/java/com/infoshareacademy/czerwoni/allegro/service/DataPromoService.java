package com.infoshareacademy.czerwoni.allegro.service;

import com.infoshareacademy.czerwoni.allegro.AllegroCategory;

import java.util.List;

public interface DataPromoService {
    void addCategory(AllegroCategory allegroCategory);
    AllegroCategory getPromotedCategoryById(int Id);
    List<Integer> getAllPromotedCategories();
    void removeCategory(AllegroCategory allegroCategory);
    List<AllegroCategory> setPromotedCategories();
    List<AllegroCategory> getSearchedCategories(String keyWord);
}
