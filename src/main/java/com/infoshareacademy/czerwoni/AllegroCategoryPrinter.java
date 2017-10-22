package com.infoshareacademy.czerwoni;

import java.util.ArrayList;

public class AllegroCategoryPrinter {

    static ArrayList<AllegroCategory> currentCategory = new ArrayList<AllegroCategory>();
    static ArrayList<AllegroCategory> parentCategory = new ArrayList<AllegroCategory>();

    private static void printCategory(ArrayList<AllegroCategory> allegroCategories,int categoryParent) {
        for (AllegroCategory allegroCategory : allegroCategories) {
            if (allegroCategory.getCatParent() == categoryParent) {
                int orderNumber = allegroCategory.getCatPosition() + 1;
                currentCategory.add(allegroCategory);
                if (allegroCategory.getCatParent() != 0) {
                    System.out.println("    " + orderNumber + ") " + allegroCategory.getCatName());
                }else {
                    System.out.println(orderNumber + ") " + allegroCategory.getCatName());
                }
            }
        }
    }

    public static void printMainCategories(ArrayList<AllegroCategory> allegroCategories) {
        currentCategory.clear();
        int categoryParent = 0;
        printCategory(allegroCategories, categoryParent);
    }

    public static void printChildCategories(ArrayList<AllegroCategory> allegroCategories, String chosenCategory) {

        int categoryParent = currentCategory.get(Integer.parseInt(chosenCategory)-1).getCatId();
        System.out.println(chosenCategory + " )"
                + currentCategory.get(Integer.parseInt(chosenCategory)-1).getCatName() + "\n");
        currentCategory.clear();
        printCategory(allegroCategories, categoryParent);
        if(currentCategory.isEmpty()) {
            System.out.println("To jest ostatnia kategoria.");
        }
    }

    public static void printParentCategories(ArrayList<AllegroCategory> allegroCategories) {
        int currentCategoryParent = currentCategory.get(0).getCatParent();
        for (AllegroCategory allegroCategory : allegroCategories) {
            if (allegroCategory.getCatId() == currentCategoryParent) {
                currentCategoryParent = allegroCategory.getCatParent();
                if (currentCategoryParent != 0) {
                    int orderNumber = allegroCategory.getCatPosition() + 1;
                    System.out.println(orderNumber + ") " + allegroCategory.getCatName() + "\n");
                    break;
                }
            }
        }
        currentCategory.clear();
        if (currentCategoryParent == 0) {
            AllegroCategoryPrinter.printMainCategories(allegroCategories);
        } else {
            printCategory(allegroCategories, currentCategoryParent);
        }
    }
}
