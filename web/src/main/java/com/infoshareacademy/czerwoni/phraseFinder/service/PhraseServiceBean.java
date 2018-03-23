package com.infoshareacademy.czerwoni.phraseFinder.service;

import com.infoshareacademy.czerwoni.allegro.AllegroCategory;
import com.infoshareacademy.czerwoni.allegro.repository.DataPromoRepository;
import com.infoshareacademy.czerwoni.parse.ParseXmlAllegroCategories;
import com.infoshareacademy.czerwoni.phraseFinder.domain.FoundPhraseData;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Stateless
public class PhraseServiceBean implements PhraseService {

    @Inject
    private DataPromoRepository dataPromoRepository;

    private List<AllegroCategory> allCategories = ParseXmlAllegroCategories.deserialization();

    private Map<AllegroCategory, String> getFirstXCategories(String phrase, Integer limitCategoriesToPrint)
    {

        Map<AllegroCategory, String> phraseMap = allCategories.stream().
                filter(c-> c.getCatName().toLowerCase().
                        contains(phrase.toLowerCase()))
                .limit(limitCategoriesToPrint).collect(Collectors.toMap(c -> c, AllegroCategory::generateLink));
        return phraseMap;
    }


    private String errorResponse(String msg) {
        return (msg == null) ? "Najpierw wpisz frazę, którą chcesz wyszukać." : msg;
    }

    public FoundPhraseData getDataToPrint(String category, int limit) {
        FoundPhraseData foundPhraseData = new FoundPhraseData(getFirstXCategories(category, limit));
        if (foundPhraseData.getFirstNPhrases().isEmpty()) {
            foundPhraseData.setError(errorResponse(category));
        }

        for (AllegroCategory allegroCategory : foundPhraseData.getFirstNPhrases().keySet()) {
            foundPhraseData.getBreadCrumbsMap()
                    .put(allegroCategory, dataPromoRepository.getBreadCrumbsString(allegroCategory.getCatId()));
        }
        return foundPhraseData;
    }

}
