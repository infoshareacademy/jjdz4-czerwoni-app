package com.infoshareacademy.czerwoni.phraseFinder.dao;

import com.infoshareacademy.czerwoni.allegro.AllegroCategory;
import com.infoshareacademy.czerwoni.allegro.dao.CategoriesService;
import com.infoshareacademy.czerwoni.parse.ParseXmlAllegroCategories;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class PhraseServiceBean implements PhraseService {

    List<AllegroCategory> allCategories = ParseXmlAllegroCategories.deserialization();

    @Inject
    CategoriesService categoriesService;



    @Override
    public PhraseService findPhrase(String pharaseInput) {
        return null;
    }

    @Override
    public String getCategoryByPhrase(String phrase)
    {
        AllegroCategory allegroCategory = allCategories.stream().filter(category -> category.getCatName().toLowerCase().contains(phrase.toLowerCase())).findFirst().get();
        return allegroCategory.getCatName();
    }

    @Override
    public String getLinkByPhrase(String phrase)
    {
        AllegroCategory allegroCategory = allCategories.stream().filter(category -> category.getCatName().toLowerCase().contains(phrase.toLowerCase())).findFirst().get();
        return allegroCategory.generateLink();
    }
}
