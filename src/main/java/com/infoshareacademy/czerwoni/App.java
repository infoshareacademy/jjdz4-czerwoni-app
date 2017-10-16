package com.infoshareacademy.czerwoni;


import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;

public class App
{
    public static void main( String[] args ) {
        try {
            ParseXmlAllegroCategories.deserialization();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        ArrayList<AllegroCategory> allegroCategories = new ArrayList<AllegroCategory>();
        try {
            allegroCategories = ParseXmlAllegroCategories.deserialization();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }

        for (AllegroCategory allegroCategory : allegroCategories) {

            if (Integer.parseInt(allegroCategory.getCatParent()) == 0) {
                System.out.println(allegroCategory.getCatPosition()+ ") " + allegroCategory.getCatName());
            }
        }
    }
}
