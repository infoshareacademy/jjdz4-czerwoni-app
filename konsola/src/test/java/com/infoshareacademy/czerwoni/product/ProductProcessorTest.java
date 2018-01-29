package com.infoshareacademy.czerwoni.product;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ProductProcessorTest {

    @Test
    public void getProductDataFromAPI_validArg() {
        assertThat(ProductProcessor.getProductDataFromAPI("5900084063241"))
                .startsWith("Kamis Musztarda grillowa 290 g");
    }

    @Test
    public void getProductDataFromAPI_invalidArg() {
        assertThat(ProductProcessor.getProductDataFromAPI("aaa"))
                .isNullOrEmpty();
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
