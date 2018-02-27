package com.infoshareacademy.czerwoni.phraseFinder.dao;

import com.infoshareacademy.czerwoni.allegro.AllegroCategory;
import com.infoshareacademy.czerwoni.allegro.service.CategoriesService;
import com.infoshareacademy.czerwoni.parse.ParseXmlAllegroCategories;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
    public List getLinkByPhrase(String phrase)
    {
        return allCategories.stream()
                .filter(category -> category.getCatName().toLowerCase().contains(phrase.toLowerCase()))
                .collect(Collectors.toList()).subList(0, 4);
    }
}
