package com.infoshareacademy.czerwoni;

import java.util.ArrayList;
import java.util.Scanner;

public class AllegroCategoriesUI {

    /**
     * Funkcja sterująca poruszaniem się po drzewie kategorii i generowaniem linków.
     *
     */
    public static void UserInterface() {
        ArrayList allegroCategories = ParseXmlAllegroCategories.deserialization();
        if (!(allegroCategories.isEmpty())) {
        AllegroCategoryPrinter.printMainCategories(allegroCategories);
            boolean finished = false;
            while (!finished) {
                try {
                    System.out.print("Wprowadź komendę lub numer kategorii: ");
                    Scanner keyScanner = new Scanner(System.in);
                    String enteredKey = keyScanner.nextLine();
                    switch (enteredKey.toLowerCase()) {
                        case "main":
                            System.out.print("\033[H\033[2J");
                            AllegroCategoryPrinter.printMainCategories(allegroCategories);
                            break;
                        case "back":
                            System.out.print("\033[H\033[2J");
                            System.out.println("PRZEGLĄDANIE KATEGORII ALLEGRO");
                            AllegroCategoryPrinter.printParentCategories(allegroCategories);
                            break;
                        case "exit":
                            System.out.print("\033[H\033[2J");
                            finished = true;
                            break;
                        case "generate":
                            AllegroCategoryPrinter.generateLink(allegroCategories);
                            System.out.print("\033[H\033[2J");
                            break;
                        default:
                            System.out.print("\033[H\033[2J");
                            System.out.println("PRZEGLĄDANIE KATEGORII ALLEGRO");
                            try {
                                AllegroCategoryPrinter.printChildCategories(allegroCategories, enteredKey);
                                break;
                            } catch (IndexOutOfBoundsException e) {
                                System.out.println("Wprowadzono niepoprawny numer kategorii!");
                            }
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Wprowadzono niepoprawną komendę!");
                }

            }
        }
    }
}
