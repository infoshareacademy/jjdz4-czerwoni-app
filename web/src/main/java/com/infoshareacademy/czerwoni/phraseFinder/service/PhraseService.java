package com.infoshareacademy.czerwoni.phraseFinder.service;

import com.infoshareacademy.czerwoni.allegro.AllegroCategory;

import javax.ejb.Local;
import java.util.Map;
import com.infoshareacademy.czerwoni.phraseFinder.domain.FoundPhraseData;

import javax.ejb.Local;


@Local
public interface PhraseService {

    Map<AllegroCategory, String> getFirstXCategories(String phrase, Integer limit);

    String errorResponse(String msg);
    Integer DEFAULT_LIMIT = 5;

    FoundPhraseData getDataToPrint(String category, int limit);
}