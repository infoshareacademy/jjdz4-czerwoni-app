package com.infoshareacademy.czerwoni.allegro.service;

import com.infoshareacademy.czerwoni.allegro.AllegroCategory;
import com.infoshareacademy.czerwoni.allegro.repository.DataPromoRepository;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;
import java.util.Map;

@Stateless
public class DataPromoServiceBean implements DataPromoService {

    @Inject
    DataPromoRepository dataPromoRepository;

    @Override
    public boolean addCategory(int id) {
        return dataPromoRepository.addCategory(id);
    }

    @Override
    public AllegroCategory getPromotedCategoryById(int id) {
        return dataPromoRepository.getPromotedCategoryById(id);
    }

    @Override
    public List<AllegroCategory> getAllPromotedCategories() {
        return dataPromoRepository.getAllCategories();
    }

    @Override
    public boolean removeCategory(int id) {
        return dataPromoRepository.removeCategory(id);
    }

    @Override
    public List<AllegroCategory> setPromotedCategories() {
        return dataPromoRepository.setPromotedCategories();
    }

    @Override
    public Map<AllegroCategory, String> getSearchedCategories(String keyWord) {
        return dataPromoRepository.getSearchedCategories(keyWord);
    }
}
