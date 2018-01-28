package com.infoshareacademy.czerwoni.phraseFinder.dao;

import javax.ejb.Local;

@Local
public interface PhraseService {

        PhraseService findPhrase(String pharaseInput);
        String getCategoryByPhrase(String phrase);
        String getLinkByPhrase(String phrase);
}
