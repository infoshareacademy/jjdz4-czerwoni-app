package com.infoshareacademy.czerwoni;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.ArrayList;


@JacksonXmlRootElement(localName = "ns1:item")
public class AllegroCategory {

    @JacksonXmlProperty(localName = "ns1:catId")
    private String catId;

    @JacksonXmlProperty(localName = "ns1:catName")
    private String catName;

    @JacksonXmlProperty(localName = "ns1:catPosition")
    private String catPosition;

    @JacksonXmlProperty(localName = "catParent")
    private String catParent;

    @JacksonXmlProperty(localName = "catIsProductCatalogueEnabled")
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
