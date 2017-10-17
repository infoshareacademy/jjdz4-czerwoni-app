package com.infoshareacademy.czerwoni;

import java.util.ArrayList;

public class AllegroCategoryPrinter {

    public static void printMainCategories(ArrayList<AllegroCategory> allegroCategories) {
        for (AllegroCategory allegroCategory : allegroCategories) {
            if (allegroCategory.getCatParent() == 0) {
                int orderNumber = allegroCategory.getCatPosition() + 1;
                System.out.println(orderNumber + ") " + allegroCategory.getCatName());
            }
        }
    }

    public static void printChildCategories(ArrayList<AllegroCategory> allegroCategories, int chosenCategory) {
        ArrayList<AllegroCategory> childCategories = new ArrayList<AllegroCategory>();
        for (AllegroCategory allegroCategory : allegroCategories) {
            if (allegroCategory.getCatParent() == chosenCategory) {
                int orderNumber = allegroCategory.getCatPosition() + 1;

                System.out.println(orderNumber + " )" + allegroCategory.getCatName());
            }
        }
    }

    public static void printParentCategories(ArrayList<AllegroCategory> allegroCategories) {
        for (AllegroCategory allegroCategory : allegroCategories) {

        }
    }



}
