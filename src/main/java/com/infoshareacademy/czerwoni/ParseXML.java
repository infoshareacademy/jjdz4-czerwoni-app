package com.infoshareacademy.czerwoni;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class ParseXML {

    /* TODO
    1.Tworzenie pytań i zapis do pliku. Jeżeli plik nie istnieje to program powinien go stworzyć.
    2.Odczyt pytania
    3.Przypisanie pytań do kategorii
    4.
    */



    public static void main(String args[]) {
        try {

            File fXmlFile = new File("CatQuestions.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);
            doc.getDocumentElement().normalize();
            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
            System.out.println("Root element :" + doc.getElementsByTagName("ELEKTRONIKA").item(0));
            NodeList nList = doc.getElementsByTagName("FOTOGRAFIA");


            for(int i=0; i<nList.getLength();i++){
                Node node = nList.item(i);
                Element question = (Element) node;
                System.out.println("Element: "+node.getNodeName());
                System.out.println(i);
                System.out.println(node.getAttributes().getNamedItem("pytanie"));
                System.out.println("Odpowiedz na pytanie: "+question.getAttribute("pytanie"));
            }


        } catch (Exception e) {
            e.printStackTrace();
        }


    }


}


