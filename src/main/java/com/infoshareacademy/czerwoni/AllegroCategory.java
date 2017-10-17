package com.infoshareacademy.czerwoni;


import java.util.ArrayList;


public class AllegroCategory {

    private Integer catId;
    private String catName;
    private Integer catPosition;
    private Integer catParent;
    private String catIsProductCatalogueEnabled;
    private ArrayList<AllegroCategory> categoryChild;

    public AllegroCategory(Integer catId,
                           String catName,
                           Integer catPosition,
                           Integer catParent) {
        this.catId = catId;
        this.catName = catName;
        this.catPosition = catPosition;
        this.catParent = catParent;
    }

    public Integer getCatId() {
        return catId;
    }

    public void setCatId(Integer catId) {
        this.catId = catId;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public Integer getCatPosition() {
        return catPosition;
    }

    public void setCatPosition(Integer catPosition) {
        this.catPosition = catPosition;
    }

    public Integer getCatParent() {
        return catParent;
    }

    public void setCatParent(Integer catParent) {
        this.catParent = catParent;
    }

    public String isCatIsProductCatalogueEnabled() {
        return catIsProductCatalogueEnabled;
    }

    public void setCatIsProductCatalogueEnabled(String catIsProductCatalogueEnabled) {
        this.catIsProductCatalogueEnabled = catIsProductCatalogueEnabled;
    }

    public ArrayList<AllegroCategory> getCategoryChild() {
        return categoryChild;
    }

    public void setCategoryChild(ArrayList<AllegroCategory> categoryChild) {
        this.categoryChild = categoryChild;
    }

    @Override
    public String toString() {
        return "AllegroCategory{" +
                "catId=" + catId +
                ", catName='" + catName + '\'' +
                ", catPosition=" + catPosition +
                ", catParent=" + catParent +
                ", catIsProductCatalogueEnabled=" + catIsProductCatalogueEnabled +
                ", categoryChild=" + categoryChild +
                '}';
    }
}
