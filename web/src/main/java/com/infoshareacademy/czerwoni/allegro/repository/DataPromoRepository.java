package com.infoshareacademy.czerwoni.allegro.repository;

import com.infoshareacademy.czerwoni.allegro.AllegroCategory;
import com.infoshareacademy.czerwoni.allegro.dao.CategoriesService;
import com.infoshareacademy.czerwoni.allegro.domain.DataPromo;
import com.infoshareacademy.czerwoni.parse.ParseXmlAllegroCategories;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class DataPromoRepository {

    List<AllegroCategory> allegroCategories = ParseXmlAllegroCategories.deserialization();
    @EJB
    CategoriesService categoriesService;

    @PersistenceContext(unitName = "pUnit")
    EntityManager entityManager;

    public void addCategory(AllegroCategory allegroCategory) {entityManager.persist(allegroCategory.getCatId());}

    public void removeCategory(AllegroCategory allegroCategory) {entityManager.remove(entityManager.contains(allegroCategory));}

    public AllegroCategory getPromotedCategoryById(Integer id) {
        return allegroCategories.stream()
                .filter(category -> category.getCatId() == entityManager.find(DataPromo.class, id).getPromotedCategory())
                .findFirst()
                .get();
    }

    public List<AllegroCategory> setPromotedCategories(List<AllegroCategory> categories) {
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
}
