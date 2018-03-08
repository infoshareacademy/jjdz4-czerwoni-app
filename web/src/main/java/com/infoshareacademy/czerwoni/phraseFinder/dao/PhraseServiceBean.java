package com.infoshareacademy.czerwoni.phraseFinder.dao;

import com.infoshareacademy.czerwoni.allegro.AllegroCategory;
import com.infoshareacademy.czerwoni.parse.ParseXmlAllegroCategories;

import javax.ejb.Stateless;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Stateless
public class PhraseServiceBean implements PhraseService {

    List<AllegroCategory> allCategories = ParseXmlAllegroCategories.deserialization();

    @Override
    public Map<AllegroCategory, String> getFirstXCategories(String phrase, int limitCategoriesToPrint)
    {

        Map<AllegroCategory, String> phraseMap = allCategories.stream().
                filter(c-> c.getCatName().toLowerCase().
                        contains(phrase.toLowerCase()))
                .limit(limitCategoriesToPrint).collect(Collectors.toMap(c -> c, AllegroCategory::generateLink));



        return phraseMap;
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
