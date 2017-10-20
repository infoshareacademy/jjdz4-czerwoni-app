package com.infoshareacademy.czerwoni;

import org.json.simple.JSONObject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Base64;

class ProductProcessor {

    static private String getProductDataFromAPI(String barcode) {

        try {
            String webAPI = "http://www.produktywsieci.gs1.pl/api/products/" + barcode + "?aggregation=SOCIAL";
            String name = "test", password = "test123";
            String authString = name + ":" + password;
            String authEncoding = Base64.getEncoder().encodeToString((authString).getBytes("UTF-8")); // String authString = name + ":" + password;

            URL urlAPI = new URL(webAPI);
            HttpURLConnection httpURLConnection = (HttpURLConnection) urlAPI.openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setRequestProperty("Accept", "application/json");
            httpURLConnection.setRequestProperty("Authorization", "Basic " + authEncoding);

            if (httpURLConnection.getResponseCode() != 200) {
                httpURLConnection.disconnect();
                return "failed (HTTP error code : "
                        + httpURLConnection.getResponseCode() + "-" + httpURLConnection.getResponseMessage() + ")";
            /*    throw new RuntimeException("Failed : HTTP error code : "
                        + httpURLConnection.getResponseCode() + "-" +httpURLConnection.getResponseMessage());
            */
            }

            /*
        JSONObject productJSON = new JSONObject();  // productJSON = API.product.get(productBarcode);
        // tymczasowo:
        productJSON.put("GTIN", productBarcode);

           {"balance": 1000.21, "num":100, "is_vip":true, "name":"foo"}
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

        return productJSON.get("GTIN").toString();  */
            httpURLConnection.disconnect();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "success";  // return productJSON.get("GTIN").toString();
    }

    static String identifyProductFromImage(String imageFilename) {
        String productBarcode = BarCodeReader.decodeBarcodeFromFile(imageFilename);
        if (productBarcode.isEmpty()) {
            return "No barcode found/decoded";
        }
        System.out.println("Decoded barcode: " + productBarcode);

        // http://produktywsieci.gs1.pl/apidocs/index#!/ApiProducts/ApiProducts_Get
        return getProductDataFromAPI(productBarcode);
/*
        JSONObject productJSON = new JSONObject();  // productJSON = API.product.get(productBarcode);
        // tymczasowo:
        productJSON.put("GTIN", productBarcode);

           {"balance": 1000.21, "num":100, "is_vip":true, "name":"foo"}
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

        return productJSON.get("GTIN").toString();  */
    }
}
