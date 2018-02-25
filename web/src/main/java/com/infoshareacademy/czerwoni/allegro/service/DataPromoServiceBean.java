package com.infoshareacademy.czerwoni.allegro.service;

import com.infoshareacademy.czerwoni.allegro.AllegroCategory;
import com.infoshareacademy.czerwoni.allegro.repository.DataPromoRepository;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

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
    public List<Integer> getAllPromotedCategories() {
        return dataPromoRepository.getAllCategories();
    }

    @Override
    public void removeCategory(AllegroCategory allegroCategory) {
        dataPromoRepository.removeCategory(allegroCategory);
    }

    @Override
    public List<AllegroCategory> setPromotedCategories() {
        return dataPromoRepository.setPromotedCategories();
    }

    @Override
    public List<AllegroCategory> getSearchedCategories(String keyWord) {
        return dataPromoRepository.getSearchedCategories(keyWord);
    }
}
