package com.infoshareacademy.czerwoni;


import java.io.IOException;

public class App
{
    public static void main( String[] args ) {

       /* try {
            ParseXmlAllegroCategories.deserialization();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        XmlEnvelope xmlEnvelope = new XmlEnvelope();
        try {
            xmlEnvelope = ParseXmlAllegroCategories.deserialization();
        } catch (IOException e) {
            e.printStackTrace();
        }

//        System.out.println(xmlEnvelope.getBody().getDoGetCatsDataResponse().getAllegroCategories().getAllegroCategory().get(1).toString());
    }
}
