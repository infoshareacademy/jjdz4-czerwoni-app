package com.infoshareacademy.czerwoni;

import java.util.ArrayList;

public class AllegroCategoryPrinter {

    static ArrayList<AllegroCategory> currentCategory = new ArrayList<AllegroCategory>();

    public static void printMainCategories(ArrayList<AllegroCategory> allegroCategories) {
        for (AllegroCategory allegroCategory : allegroCategories) {
            if (allegroCategory.getCatParent() == 0) {
                currentCategory.add(allegroCategory);
                int orderNumber = allegroCategory.getCatPosition() + 1;
                System.out.println(orderNumber + ") " + allegroCategory.getCatName());
            }
        }
    }

    public static void printChildCategories(ArrayList<AllegroCategory> allegroCategories, int chosenCategory) {
        ArrayList<AllegroCategory> childCategories = new ArrayList<AllegroCategory>();
        int categoryParent = currentCategory.get(chosenCategory-1).getCatId();
        System.out.println(chosenCategory + " )" + currentCategory.get(chosenCategory-1).getCatName() + "\n");
        currentCategory.clear();
        for (AllegroCategory allegroCategory : allegroCategories) {
            if (allegroCategory.getCatParent() == categoryParent) {
                int orderNumber = allegroCategory.getCatPosition() + 1;
                currentCategory.add(allegroCategory);
                System.out.println("    " + orderNumber + " )" + allegroCategory.getCatName());
            }
        }
    }

    public static void printParentCategories(ArrayList<AllegroCategory> allegroCategories) {
        for (AllegroCategory allegroCategory : allegroCategories) {

        }
    }



}
