package com.infoshareacademy.czerwoni;

import java.util.ArrayList;
import java.util.Scanner;

public class PhraseFinder {

    public String PhraseScanner(String s) {
        Scanner scanner = new Scanner(System.in);

        String phrase = scanner.nextLine();
        System.out.println(phrase);


        return phrase;
    }

    public static void PhraseResearch(String s, ArrayList<AllegroCategory> allegroCategories) {

        String search = s;
        for (AllegroCategory allegroCategory : allegroCategories) {
            if (allegroCategory.getCatName().contains(search)) {
                System.out.println(allegroCategory.getCatName());
            } else {
                System.out.println("Shit happens. :0");
            }
        }
    }
}
