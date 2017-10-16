package com.infoshareacademy.czerwoni;


import java.util.ArrayList;

public class AllegroCategories {

    ArrayList<AllegroCategory> allegroCategory;

    public ArrayList<AllegroCategory> getAllegroCategory() {
        return allegroCategory;
    }

    public void setAllegroCategory(ArrayList<AllegroCategory> allegroCategory) {
        this.allegroCategory = allegroCategory;
    }

    @Override
    public String toString() {
        return "AllegroCategories{" +
                "allegroCategory=" + allegroCategory.toString() +
                '}';
    }


}
