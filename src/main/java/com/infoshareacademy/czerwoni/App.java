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

        AllegroCategoriesUI.UserInterface(allegroCategories);
    }
}
