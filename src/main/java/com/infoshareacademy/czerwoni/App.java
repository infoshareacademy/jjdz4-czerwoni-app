package com.infoshareacademy.czerwoni;

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
                System.out.print("");
            }
            int choice;
            for (choice = scanner.nextInt(); choice < 0 || choice > 5; choice = scanner.nextInt()) {
                System.out.print("Błędna wartość! Proszę podać cyfrę od 0 do 4: ");
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
                    PhraseFinder.PhraseResearch();
                    System.out.println();
                    break;
                case 4:
                    ProductProcessor.identifyProductFromImage();
                    break;
                case 0:
                    printOut();
                    System.out.println("Do zobaczenia wkrótce!");
                    onOff = false;
                    break;
                default:
                    System.out.println("\nCoś poszło nie tak, proszę spróbuj ponownie\n");
            }


        }
    }


    private static void printOut() {
        System.out.println("");
        System.out.println("\033[33mWitamy w aplikacji - \"What Do You Want\" \033[0m");
        System.out.println("\033[33m===============================================\033[0m");
        System.out.println("1: Wyszukiwarka kategorii na podstawie pytań");
        System.out.println("2: Kategorie allegro");
        System.out.println("3: Wybierz docelową kategorię po frazie");
        System.out.println("4: Wyszukiwarka produktu poprzez kod kreskowy");
        System.out.println("\033[33m0: Wyjście z aplikacji\033[0m\n");

        System.out.print("Wybierz opcję: ");
    }

}
