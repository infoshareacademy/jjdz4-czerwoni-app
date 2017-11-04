package com.infoshareacademy.czerwoni;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class PhraseFinder {

    public static String PhraseScanner() {
        Scanner scanner = new Scanner(System.in);

        String phrase = scanner.nextLine();
        System.out.println(phrase);


        return phrase;
    }

    public static void PhraseResearch() {

        ArrayList<AllegroCategory> allegroCategories = ParseXmlAllegroCategories.deserialization();
        System.out.println("Podaj frazę, po której chciałbyś szukać");
        String search = PhraseScanner();
        int counter = 0;
        for (AllegroCategory allegroCategory : allegroCategories) {
                if (allegroCategory.getCatName().contains(search)) {
                    System.out.println("Linki do Twojej kategorii: ");
                    System.out.println(allegroCategory.generateLink());
                }
            }
        }
    }

