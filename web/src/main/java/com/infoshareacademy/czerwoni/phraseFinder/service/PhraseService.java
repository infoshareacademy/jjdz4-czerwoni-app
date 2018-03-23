package com.infoshareacademy.czerwoni.phraseFinder.service;

import com.infoshareacademy.czerwoni.allegro.AllegroCategory;
import com.infoshareacademy.czerwoni.phraseFinder.domain.FoundData;

import javax.ejb.Local;
import java.util.Map;


@Local
public interface PhraseService {

        Map<AllegroCategory, String> getFirstXCategories(String phrase, Integer limit);

        String errorResponse(String msg);

    FoundData dataToPrint(String category, int limit);
}