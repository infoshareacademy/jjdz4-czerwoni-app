package com.infoshareacademy.czerwoni;


import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.util.ArrayList;

public class ParseXmlAllegroCategories {


    public static ArrayList deserialization() throws IOException, SAXException, ParserConfigurationException {

        File file = new File("Allegro_cathegories_2016-02-13.xml");
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.parse(file);
        document.getDocumentElement().normalize();
        NodeList nodeList = document.getElementsByTagName("ns1:item");
        ArrayList<AllegroCategory> allegroCategories = new ArrayList<AllegroCategory>();
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            Element element = (Element) node;
            allegroCategories.add(new AllegroCategory(element.getElementsByTagName("ns1:catId").item(0).getTextContent(),
                    element.getElementsByTagName("ns1:catName").item(0).getTextContent(),
                            element.getElementsByTagName("ns1:catPosition").item(0).getTextContent(),
                            element.getElementsByTagName("ns1:catParent").item(0).getTextContent()));
        }
        return allegroCategories;
    }
}
