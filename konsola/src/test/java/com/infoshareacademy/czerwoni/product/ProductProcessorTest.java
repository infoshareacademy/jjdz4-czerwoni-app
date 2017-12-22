package com.infoshareacademy.czerwoni.product;

import org.junit.Test;

public class ProductProcessorTest {

    @Test
    public void getProductDataFromAPI_validArg() {
        System.out.println(ProductProcessor.FOUND_PRODUCT_MSG
                + ProductProcessor.getProductDataFromAPI("5900084063241"));
    }

    @Test
    public void getProductDataFromAPI_invalidArg() {
        System.out.println(ProductProcessor.FOUND_PRODUCT_MSG
                + ProductProcessor.getProductDataFromAPI("aaa"));
    }

    /*
    taki przypadek w praktyce nie zaistnieje, gdyz jest zabezpieczenie przed nim,
    tj. nie dojdzie wtedy do wywołania funkcji getProductDataFromAPI()

    @Test
    public void getProductDataFromAPI_nullArg() {
        ProductProcessor.getProductDataFromAPI(null);
    }  */

    /*
    taki przypadek w praktyce nie zaistnieje, gdyz jest zabezpieczenie przed nim,
    tj. nie dojdzie wtedy do wywołania funkcji getProductDataFromAPI()

    @Test
    public void getProductDataFromAPI_emptyArg() {
        ProductProcessor.getProductDataFromAPI("");
    } */

}
