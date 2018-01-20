package com.infoshareacademy.czerwoni.allegro.dao;

import com.beust.jcommander.internal.Lists;
import com.infoshareacademy.czerwoni.allegro.AllegroCategory;
import com.infoshareacademy.czerwoni.parse.ParseXmlAllegroCategories;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.*;
import java.util.stream.Collectors;

@Stateless
public class CategoriesServiceBean implements CategoriesService {

    List<AllegroCategory> allCategories = ParseXmlAllegroCategories.deserialization();

    @EJB
    CategoriesService categoriesRepositoryDao;

    @Override
    public Map<AllegroCategory, String> getCategories(int parentId) {
        Map<AllegroCategory, String> categoriesMap;
        categoriesMap = allCategories.stream()
                .filter(category -> category.getCatParent() == parentId)
                .collect(Collectors.toMap(category -> category, AllegroCategory::generateLink));
        return categoriesMap.entrySet().stream()
                .sorted(Comparator.comparing(category -> category.getKey().getCatPosition()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new));
    }

    @Override
    public AllegroCategory getMainCategory(int catId) {
        if (catId == 0) {
            return null;
        } else {
            return allCategories.stream().filter(category -> category.getCatId() == catId).findFirst().get();
        }
    }

    @Override
    public List<AllegroCategory> getBreadCrumbs(int catId) {
        AllegroCategory category = getMainCategory(catId);
        List<AllegroCategory> breadCrumbs = new ArrayList<>();
        if (category != null) {
            while (category.getCatId() != 0) {
                category = getMainCategory(catId);
                if (!breadCrumbs.contains(category)) breadCrumbs.add(category);
                if (category.getCatParent() != 0) {
                    catId = category.getCatParent();
                } else break;
            }
        }
        Collections.reverse(breadCrumbs);
        return breadCrumbs;
    }

    private AllegroCategory getParentCat(int parentId) {
        return allCategories.stream().filter(category -> category.getCatId() == parentId).findFirst().get();
    }
}
