package com.infoshareacademy.czerwoni;

import com.fasterxml.jackson.dataformat.xml.JacksonXmlModule;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ParseXml {



    public void deserialization() throws IOException {

        File file = new File("/home/caps/Pobrane/Allegro_cathegories_2016-02-13.xml");
        XmlMapper xmlMapper = new XmlMapper();

        AllegroCategories allegroCategories = xmlMapper.readValue(file, AllegroCategories.class);
        System.out.println(allegroCategories.toString());
    }
}
