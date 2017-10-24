package com.infoshareacademy.czerwoni;

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
        System.out.println("\nPRZEGLĄDANIE KATEGORII");
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

    /**
     *
     * @param allegroCategories
     */
    public static void generateLink(ArrayList<AllegroCategory> allegroCategories) {
        System.out.println("\nGENEROWANIE LINKU DO KATEGORII\n");
        boolean finished = false;
        while (!finished) {
            try {
                System.out.print("Wprowadź numer kategorii, aby wygenerować link " +
                        "lub [Back] aby powrócić do przeglądania kategorii: ");
                Scanner keyScanner = new Scanner(System.in);
                String enteredKey = keyScanner.nextLine();
                switch (enteredKey.toLowerCase()) {
                    case "back":
                        finished = true;
                        break;
                    default:
                        for (AllegroCategory allegroCategory : allegroCategories) {
                            if (Objects.equals(allegroCategory.getCatId(), currentCategory.get(Integer.parseInt(enteredKey) - 1).getCatId())) {
                                System.out.println("\nLink: " + allegroCategory.generateLink());
                            }
                        }
                }
            } catch (NumberFormatException e) {
                System.out.println("\nWprowadzono niepoprawną komendę!\n");
            } catch (IndexOutOfBoundsException e) {
                System.out.println("\nWprowadzono nieprawidłowy numer kategorii!\n");
            }
        }
        printMainCategories(allegroCategories);
    }
}
