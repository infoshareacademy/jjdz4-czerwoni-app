package com.infoshareacademy.czerwoni.allegro.repository;

import com.infoshareacademy.czerwoni.allegro.AllegroCategory;
import com.infoshareacademy.czerwoni.allegro.service.CategoriesService;
import com.infoshareacademy.czerwoni.allegro.domain.DataPromo;
import com.infoshareacademy.czerwoni.allegro.service.CategoriesServiceBean;
import com.infoshareacademy.czerwoni.parse.ParseXmlAllegroCategories;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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
            entityManager.persist(dataPromo);
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

    public List<Integer> getAllCategories() {
        List promoCatOb = entityManager.createNamedQuery("getAllPromotedCategories").getResultList();
        List<Integer> promoCatInt = new ArrayList<>();
        for (Object id: promoCatOb) {
            promoCatInt.add((Integer) id);
        }
        return promoCatInt;
    }

    public Map<AllegroCategory, List<AllegroCategory>> getSearchedCategories(String keyWord) {
        return categories.stream()
                .filter(allegroCategory -> allegroCategory
                        .getCatName()
                        .equalsIgnoreCase(keyWord))
                .collect(Collectors.toMap(category -> category, category -> categoriesService.getBreadCrumbs(category.getCatId())));
    }

    private boolean checkIfCategoryExists(int id) {
        return categoriesService.checkIfCategoryExists(id);
    }
}
