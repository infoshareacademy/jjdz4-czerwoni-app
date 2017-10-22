package com.infoshareacademy.czerwoni;


import java.util.ArrayList;


public class AllegroCategory {

    private Integer catId;
    private String catName;
    private Integer catPosition;
    private Integer catParent;
    private String catIsProductCatalogueEnabled;
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

    public static String generateLink(AllegroCategory allegroCategory) {
        String categoryName = allegroCategory.catName;
        categoryName = categoryName.replace(" ", "-");
        StringBuilder link = new StringBuilder();
        link.append("https://allegro.pl/kategoria/")
                .append(categoryName)
                .append("-")
                .append(allegroCategory.getCatId())
                .append("?order=m\n");
        return link.toString();
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
