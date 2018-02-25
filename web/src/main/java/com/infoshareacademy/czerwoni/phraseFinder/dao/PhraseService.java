package com.infoshareacademy.czerwoni.phraseFinder.dao;

import javax.ejb.Local;
import java.util.List;

@Local
public interface PhraseService {

        PhraseService findPhrase(String pharaseInput);
        String getCategoryByPhrase(String phrase);
        List getLinkByPhrase(String phrase);
}
