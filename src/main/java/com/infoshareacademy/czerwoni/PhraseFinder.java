package com.infoshareacademy.czerwoni;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class PhraseFinder {

    public static String PhraseScanner() {
        Scanner scanner = new Scanner(System.in);

        String phrase = scanner.nextLine();

        return phrase;
    }

    public static void phraseResearch() {

        ArrayList<AllegroCategory> allegroCategories = ParseXmlAllegroCategories.deserialization();
        boolean counter = true;
        boolean hasCategory = false;
        while (counter) {
            System.out.print("Podaj frazę, po której chciałbyś szukać: ");
            String search = PhraseScanner();
            if(search.toLowerCase().equals("exit")){
                break;
            }
            System.out.println("Linki do kategorii: " + search);


            for (AllegroCategory allegroCategory : allegroCategories) {
                if (allegroCategory.getCatName().toLowerCase().contains(search)) {
                  //  System.out.println("Linki do kategorii: " + allegroCategory.getCatName());
                    BreadcrumbsCategories.breadcrumbsPrinter(allegroCategory.getCatId());
                    System.out.println(allegroCategory.generateLink());
                    counter = false;
                    hasCategory = true;
                   // System.out.println("Naciśnij enter aby przejść do Menu\n");
                    //PhraseScanner();
                    //break;
                }
            }
            if(hasCategory){
            System.out.println("Brak kategorii do podanej frazy! Spróbuj jeszcze raz");
            }
        }
    }}