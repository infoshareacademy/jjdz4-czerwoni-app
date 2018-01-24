package com.infoshareacademy.czerwoni.allegro.repository;

import com.infoshareacademy.czerwoni.allegro.AllegroCategory;
import com.infoshareacademy.czerwoni.allegro.domain.DataPromo;
import com.infoshareacademy.czerwoni.parse.ParseXmlAllegroCategories;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class DataPromoRepository {

    List<AllegroCategory> allegroCategories = ParseXmlAllegroCategories.deserialization();

    @PersistenceContext(unitName = "pUnit")
    EntityManager entityManager;

    public void addCategory(AllegroCategory allegroCategory) {entityManager.persist(allegroCategory.getCatId());}

    public void removeCategory(AllegroCategory allegroCategory) {entityManager.remove(entityManager.contains(allegroCategory));}

    public AllegroCategory getPromotedCategoryById(int id) {
        return allegroCategories.stream()
                .filter(category -> category.getCatId() == entityManager.find(DataPromo.class, id).getPromotedCategory())
                .findFirst()
                .get();
    }

    public List<AllegroCategory> getAllCategories() {return entityManager.createNamedQuery("getAllPromotedCategories").getResultList();}
}
