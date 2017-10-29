package com.infoshareacademy.czerwoni;

import org.w3c.dom.*;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * Klasa pozwala na  parsowanie pliku XML
 */
class ParseXML {

    private DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
    private Document doc;
    private String pathName;

    ParseXML(String pathName) {
        this.pathName = pathName;
    }

    /**
     * Metoda zwraca document XML do obiektu typu Document
     * @return document XML - obiekt klasy Document
     */
    Document getXMLDocument() {
        try {
            File fXmlFile = new File(pathName);
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(fXmlFile);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
        return doc;
    }
}
