package com.infoshareacademy.czerwoni.phraseFinder.domain;

import com.infoshareacademy.czerwoni.allegro.AllegroCategory;

import java.util.HashMap;
import java.util.Map;

public class FoundPhraseData {
    private Map<AllegroCategory, String> firstNPhrases;
    private String error;
    private HashMap<AllegroCategory, String> breadCrumbsMap;

    public FoundPhraseData(Map<AllegroCategory, String> firstNPhrases) {
        this.firstNPhrases = firstNPhrases;
        this.breadCrumbsMap = new HashMap<>();
    }

    public Map<AllegroCategory, String> getFirstNPhrases() {
        return firstNPhrases;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public Map<AllegroCategory, String> getBreadCrumbsMap() {
        return breadCrumbsMap;
    }

}
