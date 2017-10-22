package com.infoshareacademy.czerwoni;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class AllegroCategoryPrinter {

    private static ArrayList<AllegroCategory> currentCategory = new ArrayList<>();

    private static void printCategory(ArrayList<AllegroCategory> allegroCategories,int categoryParent) {

        for (AllegroCategory allegroCategory : allegroCategories) {
            if (allegroCategory.getCatParent() == categoryParent) {
                int orderNumber = allegroCategory.getCatPosition() + 1;
                currentCategory.add(allegroCategory);
                System.out.println("    " + orderNumber + ") " + allegroCategory.getCatName());
            }
        }
        System.out.println("\n[Main - powrót do Kategorii Głównych] " +
                "[Back - powrót do Kategorii Nadrzędnej] " +
                "[Generate - generuje link wybranej kategorii] " +
                "[Exit - powrót do Menu Głównego]\n");
    }

    public static void printMainCategories(ArrayList<AllegroCategory> allegroCategories) {
        currentCategory.clear();
        System.out.println("\nKategorie główne:");
        int categoryParent = 0;
        printCategory(allegroCategories, categoryParent);
    }

    public static void printChildCategories(ArrayList<AllegroCategory> allegroCategories, String chosenCategory) {

        int categoryParent = currentCategory.get(Integer.parseInt(chosenCategory)-1).getCatId();
        System.out.println("\n" + chosenCategory + ") "
                + currentCategory.get(Integer.parseInt(chosenCategory)-1).getCatName() + ":");
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
                break;
            }
        }
        for (AllegroCategory allegroCategory : allegroCategories) {
            if (allegroCategory.getCatId() == currentCategoryParent) {
                int parentOrderNumber = allegroCategory.getCatPosition() + 1;
                System.out.println("\n" + parentOrderNumber + ") " + allegroCategory.getCatName());
                break;
            }
        }
        currentCategory.clear();
        printCategory(allegroCategories, currentCategoryParent);
    }

    public static void generateLink(ArrayList<AllegroCategory> allegroCategories) {
        System.out.println("Generowanie linku do kategorii");
        System.out.print("    Wprowadź numer kategorii: ");
        Scanner keyScanner = new Scanner(System.in);
        String enteredKey = keyScanner.nextLine();
        for (AllegroCategory allegroCategory : allegroCategories) {
            if (Objects.equals(allegroCategory.getCatId(), currentCategory.get(Integer.parseInt(enteredKey) - 1).getCatId())) {
                System.out.println(AllegroCategory.generateLink(allegroCategory));
            }
        }
    }
}
