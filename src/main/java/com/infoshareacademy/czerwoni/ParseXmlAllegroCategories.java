package com.infoshareacademy.czerwoni;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.*;

public class ParseXmlAllegroCategories {

    public static String inputStreamToString(InputStream is) throws IOException {
        StringBuilder sb = new StringBuilder();
        String line;
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }
        br.close();
        return sb.toString();
    }

    public static XmlEnvelope deserialization() throws IOException {

        File file = new File("Allegro_cathegories_2016-02-13.xml");
        XmlMapper xmlMapper = new XmlMapper();
//        xmlMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        String xmlInString = inputStreamToString(new FileInputStream(file));
        XmlEnvelope soapenvEnvelope = xmlMapper.readValue(xmlInString, XmlEnvelope.class);

        return soapenvEnvelope;
    }
}
