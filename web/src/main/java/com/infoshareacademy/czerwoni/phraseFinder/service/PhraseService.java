package com.infoshareacademy.czerwoni.phraseFinder.service;

import com.infoshareacademy.czerwoni.phraseFinder.domain.FoundPhraseData;

import javax.ejb.Local;


@Local
public interface PhraseService {

    Integer DEFAULT_LIMIT = 5;

    FoundPhraseData getDataToPrint(String category, int limit);
}