package com.infoshareacademy.czerwoni;


import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class App
{
    public static void main( String[] args ) {

        ArrayList<AllegroCategory> allegroCategories;
        allegroCategories = ParseXmlAllegroCategories.deserialization();
        AllegroCategoryPrinter.printMainCategories(allegroCategories);

        while (true) {
            System.out.print("\nWprowadź numer kategorii: ");
            Scanner keyScanner = new Scanner(System.in);
            String enteredKey = keyScanner.nextLine();
            char enteredKeyChar = enteredKey.charAt(0);
            switch (enteredKeyChar) {
                case 'm' : AllegroCategoryPrinter.printMainCategories(allegroCategories);
                    break;
                case 'M' : AllegroCategoryPrinter.printMainCategories(allegroCategories);
                    break;
                case 'b' : AllegroCategoryPrinter.printParentCategories(allegroCategories);
                    break;
                case 'B' : AllegroCategoryPrinter.printParentCategories(allegroCategories);
                    break;
                default: AllegroCategoryPrinter.printChildCategories(allegroCategories, enteredKey);
                    break;
            }
        }
    }
}
