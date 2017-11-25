package com.infoshareacademy.czerwoni;

import org.w3c.dom.*;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Klasa pozwala na  parsowanie pliku XML
 */
class ParseXML {

    private DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
    private Document doc;
    private String pathName;
    Logger logger = LoggerFactory.getLogger(ParseXML.class.getName());
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
            logger.info("Plik XML zosał wczytany");
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
