package com.infoshareacademy.czerwoni;

import java.util.ArrayList;
import java.util.Scanner;

public class AllegroCategoriesUI {

    public static void UserInterface(ArrayList<AllegroCategory> allegroCategories) {

        while (true) {
            try {
                System.out.print("\nWprowadź numer kategorii: ");
                Scanner keyScanner = new Scanner(System.in);
                String enteredKey = keyScanner.nextLine();
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
                        try {
                            AllegroCategoryPrinter.printChildCategories(allegroCategories, enteredKey);
                            break;
                        } catch (IndexOutOfBoundsException e) {
                            System.out.println("Wprowadzono niepoprawny numer kategorii!");
                            continue;
                        }
                }
            }catch (NumberFormatException e){
                System.out.println("Wprowadzono niepoprawne dane!");
                continue;
            }
        }
    }
}
