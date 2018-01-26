package com.infoshareacademy.czerwoni.allegro.domain;

import javax.persistence.*;

@Entity
@NamedQueries({
        @NamedQuery(name= "getAllPromotedCategories", query = "select promotedCategory from DataPromo"),
})
public class DataPromo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private int promoId;
    @Column(nullable = false)
    private int promotedCategory;

    public int getPromoId() {
        return promoId;
    }

    public void setPromoId(int promoId) {
        this.promoId = promoId;
    }

    public int getPromotedCategory() {
        return promotedCategory;
    }

    public void setPromotedCategory(int promotedCategory) {
        this.promotedCategory = promotedCategory;
    }
}
