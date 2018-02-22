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

    @Inject
    CategoriesService categoriesService;


    @Override
    public List<AllegroCategory> getFirst5Categories(String phrase)
    {

        List<AllegroCategory> phraseList = allCategories.stream().filter(c-> c.getCatName().toLowerCase().contains(phrase)).collect(Collectors.toList());

        List<AllegroCategory> first5 = new ArrayList<AllegroCategory>();

        Map<String, String> five = new HashMap<>();

        if (!phrase.isEmpty()){
            for(int i =0;i<5;i++){
                //first5.add(phraseList.get(i));
                first5.add(phraseList.get(i));
    //            five.put(getName(first5,i),getLink(first5, i));
            }
        }
        return first5;
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
