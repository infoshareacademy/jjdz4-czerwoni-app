package com.infoshareacademy.czerwoni;

import org.json.simple.JSONObject;

class ProductProcessor {

    static String identifyProductFromImage(String imageFilename) {
        String productBarcode = BarCodeReader.decodeBarcodeFromFile(imageFilename);

        JSONObject productJSON = new JSONObject();  // productJSON = API.product.get(productBarcode);

        // tymczasowo:
        productJSON.put("GTIN", " 05900084050142");

        /*   {"balance": 1000.21, "num":100, "is_vip":true, "name":"foo"}
        productJSON =
    {
	"GTIN": "string",
	"BrandOwner": "string",
	"Brand": "string",
	"Manufacturer": "string",
	"ProductName": "string",
	"Description": "string",
	"CountryOfOrigin": "string",
	"ProductImage": "string",
	"URL": "string",
	"IsLegal": true,
	"ModifiedDate": "2017-10-15T17:21:52.447Z"
    }

       Product product = new Product (response.data);
       return product.toString;
         */
        return productJSON.get("GTIN").toString();
    }
}
