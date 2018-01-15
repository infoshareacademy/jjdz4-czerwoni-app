package com.infoshareacademy.czerwoni.allegro.dao;

import com.infoshareacademy.czerwoni.allegro.AllegroCategory;
import com.infoshareacademy.czerwoni.parse.ParseXmlAllegroCategories;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Stateless
public class CategoriesServiceBean implements CategoriesService {

    @EJB
    CategoriesService categoriesRepositoryDao;

    @Override
    public Map<AllegroCategory, String> getCategories(int parentId) {
        List<AllegroCategory> allCategories = ParseXmlAllegroCategories.deserialization();
        Map<AllegroCategory, String> categoriesMap;
        categoriesMap = allCategories.stream()
                .filter(category -> category.getCatParent() == parentId)
                .collect(Collectors.toMap(category -> category, AllegroCategory::generateLink));
        return categoriesMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new));
    }
}
