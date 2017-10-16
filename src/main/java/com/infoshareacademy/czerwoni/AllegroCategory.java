package com.infoshareacademy.czerwoni;


import java.util.ArrayList;


public class AllegroCategory {

    private String catId;
    private String catName;
    private String catPosition;
    private String catParent;
    private String catIsProductCatalogueEnabled;
    private ArrayList<AllegroCategory> categoryChild;

    public AllegroCategory(String catId,
                           String catName,
                           String catPosition,
                           String catParent) {
        this.catId = catId;
        this.catName = catName;
        this.catPosition = catPosition;
        this.catParent = catParent;
    }

    public String getCatId() {
        return catId;
    }

    public void setCatId(String catId) {
        this.catId = catId;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public String getCatPosition() {
        return catPosition;
    }

    public void setCatPosition(String catPosition) {
        this.catPosition = catPosition;
    }

    public String getCatParent() {
        return catParent;
    }

    public void setCatParent(String catParent) {
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
