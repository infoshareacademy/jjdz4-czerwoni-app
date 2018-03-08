package com.infoshareacademy.czerwoni.phraseFinder.dao;

import com.infoshareacademy.czerwoni.allegro.AllegroCategory;

import javax.ejb.Local;
import java.util.List;
import java.util.Map;


@Local
public interface PhraseService {

        Map<AllegroCategory, String> getFirstXCategories(String phrase, int limit);
        String getName(List<AllegroCategory> listOfFive, int i);
        String getLink(List<AllegroCategory> listOfFive, int i);
}