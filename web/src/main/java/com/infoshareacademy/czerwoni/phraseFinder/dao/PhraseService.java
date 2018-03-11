package com.infoshareacademy.czerwoni.phraseFinder.dao;

import com.infoshareacademy.czerwoni.allegro.AllegroCategory;

import javax.ejb.Local;
import java.util.Map;


@Local
public interface PhraseService {

        Map<AllegroCategory, String> getFirstXCategories(String phrase, int limit);
        String errorResponse(String msg);
}