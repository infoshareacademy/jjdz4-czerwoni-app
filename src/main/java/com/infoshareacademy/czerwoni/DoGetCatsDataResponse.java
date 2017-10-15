package com.infoshareacademy.czerwoni;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;


@JacksonXmlRootElement(localName = "ns1:doGetCatsDataResponse")
public class DoGetCatsDataResponse {

    @JacksonXmlProperty(localName = "ns1:catsList")
    @JacksonXmlElementWrapper(useWrapping = false)
    AllegroCategories allegroCategories;

    public AllegroCategories getAllegroCategories() {
        return allegroCategories;
    }

    public void setAllegroCategories(AllegroCategories allegroCategories) {
        this.allegroCategories = allegroCategories;
    }
}
