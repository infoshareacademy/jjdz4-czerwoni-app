package com.infoshareacademy.czerwoni;

import java.util.ArrayList;
import java.util.Scanner;

public class AllegroCategoriesUI {

    public static void UserInterface(ArrayList<AllegroCategory> allegroCategories) {
        boolean finished = true;
        while (true && finished) {
            try {
                System.out.print("Wprowadź komendę lub numer kategorii: ");
                Scanner keyScanner = new Scanner(System.in);
                String enteredKey = keyScanner.nextLine();
                switch (enteredKey.toLowerCase()) {
                    case "main":
                        AllegroCategoryPrinter.printMainCategories(allegroCategories);
                        break;
                    case "back":
                        AllegroCategoryPrinter.printParentCategories(allegroCategories);
                        break;
                    case "exit":
                        finished = false;
                        break;
                    case "generate":
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
