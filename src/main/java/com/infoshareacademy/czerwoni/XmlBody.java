package com.infoshareacademy.czerwoni;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;


@JacksonXmlRootElement(localName = "SOAP-ENV:Body")
public class XmlBody {

    @JacksonXmlProperty(localName = "ns1:doGetCatsDataResponse")
    @JacksonXmlElementWrapper(useWrapping = false)
    DoGetCatsDataResponse doGetCatsDataResponse;

    public DoGetCatsDataResponse getDoGetCatsDataResponse() {
        return doGetCatsDataResponse;
    }

    public void setDoGetCatsDataResponse(DoGetCatsDataResponse doGetCatsDataResponse) {
        this.doGetCatsDataResponse = doGetCatsDataResponse;
    }
}
