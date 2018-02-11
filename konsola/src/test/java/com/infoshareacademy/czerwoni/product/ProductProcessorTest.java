package com.infoshareacademy.czerwoni.product;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ProductProcessorTest {

    @Test
    public void getProductDataFromAPI_validArg() {
        assertThat(ProductProcessor.getProductDescFromAPI("5900084063241"))
                .startsWith("Kamis Musztarda grillowa 290 g");
    }

    @Test
    public void getProductDataFromAPI_invalidArg() {
        assertThat(ProductProcessor.getProductDescFromAPI("aaa"))
                .isNullOrEmpty();
    }

    /*
    taki przypadek w praktyce nie zaistnieje, gdyz jest zabezpieczenie przed nim,
    tj. nie dojdzie wtedy do wywołania funkcji getProductDescFromAPI()

    @Test
    public void getProductDataFromAPI_nullArg() {
        ProductProcessor.getProductDescFromAPI(null);
    }  */

    /*
    taki przypadek w praktyce nie zaistnieje, gdyz jest zabezpieczenie przed nim,
    tj. nie dojdzie wtedy do wywołania funkcji getProductDescFromAPI()

    @Test
    public void getProductDataFromAPI_emptyArg() {
        ProductProcessor.getProductDescFromAPI("");
    } */

}
