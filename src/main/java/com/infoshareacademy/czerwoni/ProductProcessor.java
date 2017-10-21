package com.infoshareacademy.czerwoni;

import org.json.simple.JSONObject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Base64;

class ProductProcessor {

    static private String getProductDataFromAPI(String barcode) {
        String response = null;

        try {
            String webAPI = "http://www.produktywsieci.gs1.pl/api/products/" + barcode + "?aggregation=SOCIAL";

            final int statusCodeOK = 200;
            final String authName = "mateusz@infoshareacademy.com", authToken = "cc2ef9333d20dbd97bfb395e1f82fd3b4e5ef8a1e1be37598ba60faf2256efac";
            final String authString = authName + ":" + authToken;
            final String authEncoding = Base64.getEncoder().encodeToString((authString).getBytes("UTF-8")); // String authString = name + ":" + password;

            URL urlAPI = new URL(webAPI);
            HttpURLConnection httpURLConnection = (HttpURLConnection) urlAPI.openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setRequestProperty("Accept", "application/json");
            httpURLConnection.setRequestProperty("Authorization", "Basic " + authEncoding);

            /* if (httpURLConnection.getResponseCode() != statusCodeOK) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + httpURLConnection.getResponseCode() + "-" +httpURLConnection.getResponseMessage());
            }*/

            response = ((httpURLConnection.getResponseCode() == statusCodeOK) ?
                    "success : (" : "failed (HTTP error code : ")
                    + httpURLConnection.getResponseCode() + "-" + httpURLConnection.getResponseMessage() + ")";

            httpURLConnection.disconnect();

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


        } catch (MalformedURLException e) {
            // e.printStackTrace();
            System.out.println("Malformed URL has occurred");
        } catch (IOException e) {
            e.printStackTrace();
        } /* finally {
            //   return response;  // return productJSON.get("GTIN").toString();
        }  */
        return response;

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
