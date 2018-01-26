package com.infoshareacademy.czerwoni.allegro.dao;

import com.infoshareacademy.czerwoni.allegro.AllegroCategory;
import com.infoshareacademy.czerwoni.allegro.repository.DataPromoRepository;
import com.infoshareacademy.czerwoni.parse.ParseXmlAllegroCategories;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
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
    public List<Integer> getAllPromotedCategories() {
        return dataPromoRepository.getAllCategories();
    }

    @Override
    public void removeCategory(AllegroCategory allegroCategory) {
        dataPromoRepository.removeCategory(allegroCategory);
    }

    @Override
    public void setPromotedCategories(List<AllegroCategory> categories) {
        dataPromoRepository.setPromotedCategories(categories);
    }
}
