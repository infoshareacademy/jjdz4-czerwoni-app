package com.infoshareacademy.czerwoni;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;


@JacksonXmlRootElement(localName = "SOAP-ENV:Envelope")
public class XmlEnvelope {

    @JacksonXmlProperty(localName = "SOAP-ENV:Body")
    @JacksonXmlElementWrapper(useWrapping = false)
    XmlBody body;

    public XmlBody getBody() {
        return body;
    }

    public void setBody(XmlBody body) {
        this.body = body;
    }
}
