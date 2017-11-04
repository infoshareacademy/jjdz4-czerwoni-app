package com.infoshareacademy.czerwoni;


import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.sound.midi.Soundbank;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.util.ArrayList;

public class ParseXmlAllegroCategories {

    /**
     * Funkcja odczytująca dane z pliku XML, zawierającego kategorie Allegro
     * i tworząca obiekty klasy AllegroCategory.
     *
     * @return - lista obiektów kategorii Allegro.
     */
    public static ArrayList deserialization()  {
        File file = new File("src/main/resources/Allegro_cathegories_2016-02-13.xml");
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = null;
        try {
            documentBuilder = documentBuilderFactory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        Document document = null;
        boolean finished = false;
        ArrayList<AllegroCategory> allegroCategories = new ArrayList<>();
        while (!finished) {
            try {
                document = documentBuilder.parse(file);
            } catch (FileNotFoundException e) {
                System.out.println("Nie znalezio pliku z kategoriami allegro!");
                finished = true;
                break;
            } catch (SAXException | IOException e) {
                e.printStackTrace();
            } catch (NullPointerException e) {
                System.out.println("Nieprawidłowe dane w pliku!");
                finished = true;
                break;
            }
            document.getDocumentElement().normalize();
            NodeList nodeList = document.getElementsByTagName("ns1:item");
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                Element element = (Element) node;
                allegroCategories.add(new AllegroCategory(
                        Integer.parseInt(element.getElementsByTagName("ns1:catId").item(0).getTextContent()),
                        element.getElementsByTagName("ns1:catName").item(0).getTextContent(),
                        Integer.parseInt(element.getElementsByTagName("ns1:catPosition").item(0).getTextContent()),
                        Integer.parseInt(element.getElementsByTagName("ns1:catParent").item(0).getTextContent())));
            }
            finished = true;
        }
        return allegroCategories;
    }
}
