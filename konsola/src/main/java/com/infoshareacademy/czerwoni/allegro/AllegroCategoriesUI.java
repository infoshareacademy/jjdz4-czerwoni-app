package com.infoshareacademy.czerwoni.allegro;

import com.infoshareacademy.czerwoni.parse.ParseXmlAllegroCategories;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Scanner;

public class AllegroCategoriesUI {

    private static Logger logger = LoggerFactory.getLogger(AllegroCategoriesUI.class);

    /**
     * Funkcja sterująca poruszaniem się po drzewie kategorii i generowaniem linków.
     *
     */
    public static void UserInterface() {
        List<AllegroCategory> allegroCategories = ParseXmlAllegroCategories.deserialization();
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
                            AllegroCategoryPrinter.printMainCategories(allegroCategories);
                            break;
                        case "back":
                            System.out.println("PRZEGLĄDANIE KATEGORII ALLEGRO");
                            AllegroCategoryPrinter.printParentCategories(allegroCategories);
                            break;
                        case "exit":
                            finished = true;
                            break;
                        case "generate":
                            AllegroCategoryPrinter.generateLink(allegroCategories);
                            break;
                        default:
                            System.out.println("PRZEGLĄDANIE KATEGORII ALLEGRO");
                            try {
                                AllegroCategoryPrinter.printChildCategories(allegroCategories, enteredKey);
                                break;
                            } catch (IndexOutOfBoundsException e) {
                                String msg = "Wprowadzono niepoprawny numer kategorii!";
                                System.out.println(msg);
                                logger.debug(msg, e);
                            }
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Wprowadzono niepoprawną komendę!");
                }

            }
        }
    }
}
