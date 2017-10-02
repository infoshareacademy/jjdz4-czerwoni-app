package com.infoshareacademy.czerwoni;

import java.util.ArrayList;

public class AllegroCategory {

    private int catId;
    private String catName;
    private int catPosition;
    private int catParent;
    private boolean catIsProductCatalogueEnabled;
    private ArrayList<AllegroCategory> categoryChild;

    public AllegroCategory(int catId,
                           String catName,
                           int catPosition,
                           int catParent) {

        this.catId = catId;
        this.catName = catName;
        this.catPosition = catPosition;
        this.catParent = catParent;
    }

    public int getCatId() {
        return catId;
    }

    public void setCatId(int catId) {
        this.catId = catId;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public int getCatPosition() {
        return catPosition;
    }

    public void setCatPosition(int catPosition) {
        this.catPosition = catPosition;
    }

    public int getCatParent() {
        return catParent;
    }

    public void setCatParent(int catParent) {
        this.catParent = catParent;
    }

    public boolean isCatIsProductCatalogueEnabled() {
        return catIsProductCatalogueEnabled;
    }

    public void setCatIsProductCatalogueEnabled(boolean catIsProductCatalogueEnabled) {
        this.catIsProductCatalogueEnabled = catIsProductCatalogueEnabled;
    }

    public ArrayList<AllegroCategory> getCategoryChild() {
        return categoryChild;
    }

    public void setCategoryChild(ArrayList<AllegroCategory> categoryChild) {
        this.categoryChild = categoryChild;
    }
}
