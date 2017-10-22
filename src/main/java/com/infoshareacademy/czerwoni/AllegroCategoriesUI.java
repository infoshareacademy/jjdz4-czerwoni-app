package com.infoshareacademy.czerwoni;

import java.util.ArrayList;
import java.util.Scanner;

public class AllegroCategoriesUI {

    public static void UserInterface(ArrayList<AllegroCategory> allegroCategories) {

        while (true) {
            System.out.print("\nWprowadź numer kategorii: ");
            Scanner keyScanner = new Scanner(System.in);
            String enteredKey = keyScanner.nextLine();
            char enteredKeyChar = enteredKey.charAt(0);
            switch (enteredKey) {
                case "Main":
                    AllegroCategoryPrinter.printMainCategories(allegroCategories);
                    break;
                case "main":
                    AllegroCategoryPrinter.printMainCategories(allegroCategories);
                    break;
                case "Back":
                    AllegroCategoryPrinter.printParentCategories(allegroCategories);
                    break;
                case "back":
                    AllegroCategoryPrinter.printParentCategories(allegroCategories);
                    break;
                default:
                    AllegroCategoryPrinter.printChildCategories(allegroCategories, enteredKey);
                    break;
            }
        }
    }
}
