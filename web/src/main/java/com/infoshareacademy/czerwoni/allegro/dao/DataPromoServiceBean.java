package com.infoshareacademy.czerwoni.allegro.dao;

import com.infoshareacademy.czerwoni.allegro.AllegroCategory;
import com.infoshareacademy.czerwoni.allegro.repository.DataPromoRepository;

import javax.ejb.EJB;
import java.util.List;

public class DataPromoServiceBean implements DataPromoService {

    @EJB
    DataPromoRepository dataPromoRepository;

    @Override
    public void addCategory(AllegroCategory allegroCategory) {
        dataPromoRepository.addCategory(allegroCategory);
    }

    @Override
    public AllegroCategory getPromotedCategoryById(int id) {
        return dataPromoRepository.getPromotedCategoryById(id);
    }

    @Override
    public List<AllegroCategory> getAllPrmotedCategories() {
        return dataPromoRepository.getAllCategories();
    }

    @Override
    public void removeCategory(AllegroCategory allegroCategory) {
        dataPromoRepository.removeCategory(allegroCategory);
    }
}
