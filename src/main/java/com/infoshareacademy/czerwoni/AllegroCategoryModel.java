package com.infoshareacademy.czerwoni;

import java.util.ArrayList;
import java.util.List;


class AllegroCategoryModel {
    private int catItemID;
    private String catItemName;
    private boolean catItemVisible;
    private AllegroCategoryModel catItemParent;
    protected List<AllegroCategoryModel> catItemsChild;


    public AllegroCategoryModel(int catItemID, String catItemName, boolean catItemVisible, List<AllegroCategoryModel> catItemsChild) {
        this.catItemID = catItemID;
        this.catItemName = catItemName;
        this.catItemVisible = catItemVisible;
        this.catItemsChild = catItemsChild;

        for (AllegroCategoryModel child : this.catItemsChild) {
            child.setCatItemParent(this);
        }
    }

    public AllegroCategoryModel getCatItemParent() {
        return catItemParent;
    }

    public void setCatItemParent(AllegroCategoryModel catItemParent) {
        this.catItemParent = catItemParent;
    }


    public int getCatItemID() {
        return catItemID;
    }

    public String getCatItemName() {
        return catItemName;
    }

    public boolean isCatItemVisible() {
        return catItemVisible;
    }
}