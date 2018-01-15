package com.infoshareacademy.czerwoni.allegro.parse;


import com.infoshareacademy.czerwoni.App;
import com.infoshareacademy.czerwoni.allegro.AllegroCategory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class ParseXmlAllegroCategories {

    private static Logger logger = LoggerFactory.getLogger(ParseXmlAllegroCategories.class);

    /**
     * Funkcja odczytująca dane z pliku XML, zawierającego kategorie Allegro
     * i tworząca obiekty klasy AllegroCategory.
     *
     * @return - lista obiektów kategorii Allegro.
     */
    public List<AllegroCategory> deserialization()  {
        InputStream xmlStream = this.getClass().getClassLoader().getResourceAsStream("Allegro_cathegories_2016-02-13.xml");
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
                document = documentBuilder.parse(xmlStream);
            } catch (FileNotFoundException e) {
                String msg = "Nie znaleziono pliku z kategoriami allegro!";
                System.out.println(msg);
                logger.error(msg, e);
                finished = true;
                break;
            } catch (SAXException | IOException e) {
                e.printStackTrace();
            } catch (NullPointerException e) {
                String msg = "Nieprawidłowe dane w pliku!";
                System.out.println(msg);
                logger.error(msg, e);
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
            logger.info("Poprawny odczyt pliku XML.");
            finished = true;
        }
        return allegroCategories;
    }
}
