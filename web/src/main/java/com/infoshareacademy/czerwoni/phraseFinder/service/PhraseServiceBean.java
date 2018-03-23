package com.infoshareacademy.czerwoni.phraseFinder.service;

import com.infoshareacademy.czerwoni.allegro.AllegroCategory;
import com.infoshareacademy.czerwoni.allegro.repository.DataPromoRepository;
import com.infoshareacademy.czerwoni.parse.ParseXmlAllegroCategories;
import com.infoshareacademy.czerwoni.phraseFinder.domain.FoundData;

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

    @Override
    public Map<AllegroCategory, String> getFirstXCategories(String phrase, Integer limitCategoriesToPrint)
    {

        Map<AllegroCategory, String> phraseMap = allCategories.stream().
                filter(c-> c.getCatName().toLowerCase().
                        contains(phrase.toLowerCase()))
                .limit(limitCategoriesToPrint).collect(Collectors.toMap(c -> c, AllegroCategory::generateLink));
        return phraseMap;
    }


    @Override
    public String errorResponse(String msg) {
        String response;

        if (msg==null){
            response = "Najpierw wpisz frazę, którą chcesz wyszukać.";
        }
        else{
            response = msg;
        }
        return response;
    }

    public FoundData dataToPrint(String category, int limit) {
        FoundData foundData = new FoundData(getFirstXCategories(category, limit));
        if (foundData.getFirstNPhrases().isEmpty()) {
            foundData.setError(errorResponse(category));
        }

        // Map<AllegroCategory, String> breadCrumbsMap = new HashMap<>();
        for (AllegroCategory allegroCategory : foundData.getFirstNPhrases().keySet()) {
            foundData.getBreadCrumbsMap()
                    .put(allegroCategory, dataPromoRepository.getBreadCrumbsString(allegroCategory.getCatId()));
            // breadCrumbsMap.put(allegroCategory, dataPromoRepository.getBreadCrumbsString(allegroCategory.getCatId()));

        }
        return foundData;
    }

    ;


}
