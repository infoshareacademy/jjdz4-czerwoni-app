package com.infoshareacademy.czerwoni;

import java.util.ArrayList;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        SearchCategory searchCategory = new SearchCategory();
        boolean onOff = true;


        while (onOff) {
            Scanner scanner = new Scanner(System.in);
            printOut();
            while (!scanner.hasNextInt()) {
                System.out.println("podaj cyfrę ");
                scanner.nextLine();
            }
            int choice;
            for (choice = scanner.nextInt(); choice < 1 || choice > 8; choice = scanner.nextInt()) {
                System.out.println("Błędna wartość! Proszę podać cyfrę od 1 do 8 ");
            }

            switch (choice) {
                case 1:
                    System.out.println("");
                    searchCategory.showQuestion("1");
                    System.out.println("");
                    break;
                case 2:
                    System.out.println("");
                    AllegroCategoriesUI.UserInterface();
                    System.out.println("");
                    break;
                case 3:
                    System.out.println("WORK IN PROGRESS");
                    break;
                case 4:

                    PhraseFinder.PhraseResearch();
                    System.out.println();
                    break;
                case 5:
                    System.out.println("WORK IN PROGRESS");
                    break;
                case 6:
                    ProductProcessor.identifyProductFromImage();
                    break;
                case 7:
                    printOut();
                    break;
                case 8:
                    System.out.println("Do zobaczenia wkrótce!");
                    onOff = false;
                    break;
                default:
                    System.out.println("\nCoś poszło nie tak, proszę spróbuj ponownie\n");
            }


        }
    }


    private static void printOut() {
        System.out.println("Witamy w aplikacji What Do You Want: ");
        System.out.println("1: Wyszukiwarka kategorii na podstawie pytań");
        System.out.println("2: Kategorie allegro");
        System.out.println("3: Wyszukiwarka Ebay - ale będzie coś innego");
        System.out.println("4: Wybierz docelową kategorię po frazie");
        System.out.println("5: Sprawdź wszystkie połączenia kategorii - drzewo");
        System.out.println("6: Wyszukiwarka produktu poprzez kod kreskowy");
        System.out.println("7: MENU");
        System.out.println("8: Wyjście z aplikacji");
        System.out.print("Wybierz opcję: ");
        System.out.print("");
    }

}
