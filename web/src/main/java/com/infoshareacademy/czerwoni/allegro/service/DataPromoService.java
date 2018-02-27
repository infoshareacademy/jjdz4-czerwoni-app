package com.infoshareacademy.czerwoni.allegro.service;

import com.infoshareacademy.czerwoni.allegro.AllegroCategory;

import java.util.List;
import java.util.Map;

public interface DataPromoService {
    boolean addCategory(int id);
    AllegroCategory getPromotedCategoryById(int Id);
    List<AllegroCategory> getAllPromotedCategories();
    void removeCategory(AllegroCategory allegroCategory);
    List<AllegroCategory> setPromotedCategories();
    Map<AllegroCategory, String> getSearchedCategories(String keyWord);
}
