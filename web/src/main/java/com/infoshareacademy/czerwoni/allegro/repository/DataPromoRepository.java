package com.infoshareacademy.czerwoni.allegro.repository;

import com.infoshareacademy.czerwoni.allegro.AllegroCategory;
import com.infoshareacademy.czerwoni.allegro.service.CategoriesService;
import com.infoshareacademy.czerwoni.allegro.domain.DataPromo;
import com.infoshareacademy.czerwoni.parse.ParseXmlAllegroCategories;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.*;
import java.util.stream.Collectors;

@Stateless
public class DataPromoRepository {

    List<AllegroCategory> categories = ParseXmlAllegroCategories.deserialization();
    @EJB
    CategoriesService categoriesService;

    @PersistenceContext(unitName = "pUnit")
    EntityManager entityManager;

    public boolean addCategory(int id) {
        if (checkIfCategoryExists(id)) {
            DataPromo dataPromo = new DataPromo();
            dataPromo.setPromotedCategory(categoriesService.getCategoryById(id).getCatId());
            if (!checkIfAlreadyPromoted(id)) {
                entityManager.persist(dataPromo);
            }
            return true;
        }
        return false;
    }

    public void removeCategory(AllegroCategory allegroCategory) {entityManager.remove(entityManager.contains(allegroCategory));}

    public AllegroCategory getPromotedCategoryById(Integer id) {
        return categories.stream()
                .filter(category -> category.getCatId() == entityManager.find(DataPromo.class, id).getPromotedCategory())
                .findFirst()
                .get();
    }

    public List<AllegroCategory> setPromotedCategories() {
        List promoCatOb = entityManager.createNamedQuery("getAllPromotedCategories").getResultList();
        for (AllegroCategory category: categories) {
            category.setPromoted(false);
        }
        for (AllegroCategory category: categories) {
            for (Object id: promoCatOb) {
                if (category.getCatId().equals(id)) {
                    category.setPromoted(true);
                }
            }
        }
        return categories;
    }

    public List<AllegroCategory> getAllCategories() {
        List promoCatOb = entityManager.createNamedQuery("getAllPromotedCategories").getResultList();
        List<AllegroCategory> promoCat = new ArrayList<>();
        for (Object id: promoCatOb) {
            promoCat.add(categoriesService.getCategoryById((Integer) id));
        }
        return promoCat;
    }

    public Map<AllegroCategory, String> getSearchedCategories(String keyWord) {
        if (!keyWord.isEmpty()) {
            return categories.stream()
                    .filter(allegroCategory -> allegroCategory
                            .getCatName()
                            .toLowerCase()
                            .contains(keyWord.toLowerCase()))
                    .collect(Collectors
                            .toMap(category -> category, category -> getBreadCrumbsString(category.getCatId())));
        }
        return Collections.EMPTY_MAP;
    }

    private boolean checkIfCategoryExists(int id) {
        return categoriesService.checkIfCategoryExists(id);
    }

    private boolean checkIfAlreadyPromoted(int id) {
        List<AllegroCategory> categories = getAllCategories();
        return categories.stream()
                .anyMatch(allegroCategory -> allegroCategory.getCatId() == id);
    }

    private String getBreadCrumbsString(int id) {
        List<AllegroCategory> breadCrumbs = categoriesService.getBreadCrumbs(id);
        StringBuilder breadCrumbString = new StringBuilder();

        for (AllegroCategory category: breadCrumbs) {
            breadCrumbString
                    .append(category.getCatName())
                    .append(" > ");
        }

        return breadCrumbString.deleteCharAt(breadCrumbString.length()-2).toString();
    }
}
