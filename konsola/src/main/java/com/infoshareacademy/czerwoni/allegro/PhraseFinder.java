package com.infoshareacademy.czerwoni.allegro;

import com.infoshareacademy.czerwoni.parse.ParseXmlAllegroCategories;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.reflect.Modifier.FINAL;

public class PhraseFinder {

    public static String PhraseScanner() {

        Scanner scanner = new Scanner(System.in);

        return scanner.nextLine();
    }

    public static void phraseResearch() {
        int encounter = 0;
        final int MAX_PRINT = 5;
        List<AllegroCategory> allegroCategories = ParseXmlAllegroCategories.deserialization();
        boolean isSearching = true;
        boolean hasCategory = false;
        while (isSearching) {
            System.out.print("Podaj frazę, po której chciałbyś szukać: ");
            String search = PhraseScanner();
            if(search.toLowerCase().equals("exit")){
                break;
            }
            System.out.println("Linki do kategorii: " + search);


            for (AllegroCategory allegroCategory : allegroCategories) {

                if (allegroCategory.getCatName().toLowerCase().contains(search)) {

                    if(encounter<MAX_PRINT) {
                        BreadcrumbsCategories.breadcrumbsPrinter(allegroCategory.getCatId());
                        System.out.println(allegroCategory.generateLink());
                        isSearching = false;
                        hasCategory = true;
                    }
                    ++encounter;
                }
            }
            if(!hasCategory){
                System.out.println("\nBrak kategorii do podanej frazy! Spróbuj jeszcze raz");
                break;
            }


        }
    }}