package com.infoshareacademy.czerwoni;

import java.util.ArrayList;

public class AllegroCategoryPrinter {

    static ArrayList<AllegroCategory> currentCategory = new ArrayList<AllegroCategory>();

    public static void printMainCategories(ArrayList<AllegroCategory> allegroCategories) {
        currentCategory.clear();
        for (AllegroCategory allegroCategory : allegroCategories) {
            if (allegroCategory.getCatParent() == 0) {
                currentCategory.add(allegroCategory);
                int orderNumber = allegroCategory.getCatPosition() + 1;
                System.out.println(orderNumber + ") " + allegroCategory.getCatName());
            }
        }
    }

    public static void printChildCategories(ArrayList<AllegroCategory> allegroCategories, String chosenCategory) {
        int categoryParent = currentCategory.get(Integer.parseInt(chosenCategory)-1).getCatId();
        System.out.println(chosenCategory + " )"
                + currentCategory.get(Integer.parseInt(chosenCategory)-1).getCatName() + "\n");
        currentCategory.clear();
        for (AllegroCategory allegroCategory : allegroCategories) {
            if (allegroCategory.getCatParent() == categoryParent) {
                int orderNumber = allegroCategory.getCatPosition() + 1;
                currentCategory.add(allegroCategory);
                System.out.println("    " + orderNumber + ") " + allegroCategory.getCatName());
            }
        }
        if(currentCategory.isEmpty()) {
            System.out.println("To jest ostatnia kategoria.");
        }
    }

    public static void printParentCategories(ArrayList<AllegroCategory> allegroCategories) {

    }



}
