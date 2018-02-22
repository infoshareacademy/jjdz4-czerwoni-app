 package com.infoshareacademy.czerwoni.phraseFinder.dao;

import com.infoshareacademy.czerwoni.allegro.AllegroCategory;
import com.infoshareacademy.czerwoni.allegro.service.CategoriesService;
import com.infoshareacademy.czerwoni.parse.ParseXmlAllegroCategories;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Stateless
public class PhraseServiceBean implements PhraseService {

    List<AllegroCategory> allCategories = ParseXmlAllegroCategories.deserialization();


    @Override
    public Map<AllegroCategory, String> getFirst5Categories(String phrase)
    {

        Map<AllegroCategory, String> phraseList = allCategories.stream().filter(c-> c.getCatName().toLowerCase().contains(phrase)).
                limit(5).collect(Collectors.toMap(category -> category, AllegroCategory::generateLink));

        return phraseList;
    }


    @Override
    public String getName(List<AllegroCategory> listOfFive, int i){
        return listOfFive.get(i).getCatName();
    }

    @Override
    public String getLink(List<AllegroCategory> listOfFive, int i){
        return listOfFive.get(i).generateLink();
    }

}
