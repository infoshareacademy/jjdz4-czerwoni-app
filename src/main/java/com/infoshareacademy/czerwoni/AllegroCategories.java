package com.infoshareacademy.czerwoni;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.ArrayList;

@JacksonXmlRootElement(localName = "ns1:catsList")
public class AllegroCategories {

    @JacksonXmlProperty(localName = "ns1:item")
    @JacksonXmlElementWrapper(useWrapping = false)
    private ArrayList<AllegroCategory> allegroCategory;

    public ArrayList<AllegroCategory> getAllegroCategory() {
        return allegroCategory;
    }

    public void setAllegroCategory(ArrayList<AllegroCategory> allegroCategory) {
        this.allegroCategory = allegroCategory;
    }

    @Override
    public String toString() {
        return "AllegroCategories{" +
                "allegroCategory=" + allegroCategory.toString() +
                '}';
    }
}
