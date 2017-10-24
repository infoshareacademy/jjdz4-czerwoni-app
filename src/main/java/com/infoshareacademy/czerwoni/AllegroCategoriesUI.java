package com.infoshareacademy.czerwoni;

import java.util.ArrayList;
import java.util.Scanner;

public class AllegroCategoriesUI {

    /**
     * Funkcja sterująca poruszaniem się po drzewie kategorii i generowaniem linków.
     *
     * @param allegroCategories - Zbiór wszystkich kategorii Allegro.
     */
    public static void UserInterface(ArrayList<AllegroCategory> allegroCategories) {
        boolean finished = false;
        while (!finished) {
            try {
                System.out.print("Wprowadź komendę lub numer kategorii: ");
                Scanner keyScanner = new Scanner(System.in);
                String enteredKey = keyScanner.nextLine();
                switch (enteredKey.toLowerCase()) {
                    case "main":
                        AllegroCategoryPrinter.printMainCategories(allegroCategories);
                        break;
                    case "back":
                        System.out.println("\nPRZEGLĄDANIE KATEGORII ALLEGRO");
                        AllegroCategoryPrinter.printParentCategories(allegroCategories);
                        break;
                    case "exit":
                        finished = true;
                        System.out.println("");
                        break;
                    case "generate":
                        AllegroCategoryPrinter.generateLink(allegroCategories);
                        break;
                    default:
                        System.out.println("\nPRZEGLĄDANIE KATEGORII ALLEGRO");
                        try {
                            AllegroCategoryPrinter.printChildCategories(allegroCategories, enteredKey);
                            break;
                        } catch (IndexOutOfBoundsException e) {
                            System.out.println("Wprowadzono niepoprawny numer kategorii!");
                        }
                }
            }catch (NumberFormatException e){
                System.out.println("Wprowadzono niepoprawną komendę!");
            }
        }
    }
}
