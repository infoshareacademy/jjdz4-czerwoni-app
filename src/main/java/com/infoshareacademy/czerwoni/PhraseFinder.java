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

    public static void PhraseResearch() {

        ArrayList<AllegroCategory> allegroCategories = ParseXmlAllegroCategories.deserialization();
        boolean counter = true;
        while (counter) {
            System.out.print("Podaj frazę, po której chciałbyś szukać: ");
            String search = PhraseScanner();
            if(search.toLowerCase().equals("exit")){
                break;
            }
            int licznik = 0;


            for (AllegroCategory allegroCategory : allegroCategories) {
                licznik++;
                if (allegroCategory.getCatName().toLowerCase().contains(search)) {
                    System.out.println("Linki do kategorii: " + allegroCategory.getCatName());
                    System.out.println(allegroCategory.generateLink());
                    counter = false;
                    System.out.println("Naciśnij enter aby przejść do Menu\n");
                    PhraseScanner();
                    break;
                }
            }
            if(allegroCategories.size() == licznik){
            System.out.println("Brak kategorii do podanej frazy! Spróbuj jeszcze raz");

            }
        }
    }}