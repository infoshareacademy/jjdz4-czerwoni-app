package com.infoshareacademy.czerwoni.parse;

import com.infoshareacademy.czerwoni.App;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;

public class ParseXML {

    public static Document getXMLDocument() {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = null;
        InputStream inputStream = App.class.getClassLoader().getResourceAsStream("Categories.xml");
        try {
            documentBuilder = dbFactory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        Document doc = null;
        try {
            doc = documentBuilder.parse(inputStream);
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return doc;
    }
}
