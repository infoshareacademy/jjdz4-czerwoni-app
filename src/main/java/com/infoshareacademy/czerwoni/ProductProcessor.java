package com.infoshareacademy.czerwoni;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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
            final String authName = "mateusz@infoshareacademy.com",
                    authToken = "cc2ef9333d20dbd97bfb395e1f82fd3b4e5ef8a1e1be37598ba60faf2256efac";
            final String authString = authName + ":" + authToken;
            final String authEncoding = Base64.getEncoder().encodeToString((authString).getBytes("UTF-8"));

            URL urlAPI = new URL(webAPI);
            HttpURLConnection httpURLConnection = (HttpURLConnection) urlAPI.openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setRequestProperty("Accept", "text/json"); // "text/json"  "application/json"
            httpURLConnection.setRequestProperty("Authorization", "Basic " + authEncoding);

            /* if (httpURLConnection.getResponseCode() != statusCodeOK) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + httpURLConnection.getResponseCode() + "-" +httpURLConnection.getResponseMessage());
            }*/

            response = ((httpURLConnection.getResponseCode() == statusCodeOK) ?
                    "success : (" : "failed (HTTP error code : ")
                    + httpURLConnection.getResponseCode() + "-" + httpURLConnection.getResponseMessage() + ")";


            InputStream content = httpURLConnection.getInputStream();
            BufferedReader in =
                    new BufferedReader(new InputStreamReader(content));
            String respJSON = in.readLine();
            // {"GTIN":"05900084063241","BrandOwner":"McCORMICK POLSKA S.A.","Brand":"Kamis","Manufacturer":null,"ProductName":"Kamis Musztarda grillowa 290 g","Description":null,"CountryOfOrigin":null,"ProductImage":"http://www.produktywsieci.pl/picture_cache/103/590/0084/05900084063241_MARKT_L.jpg","URL":"http://www.kamis.pl","IsLegal":true,"ModifiedDate":"2017-10-13T22:02:10.657"}
            Gson gson = new Gson();
            // Product product = gson.fromJson(in, Product.class);
            Product product = gson.fromJson(respJSON, Product.class);

            if (product != null) {
                response = product.toString();
            } else {
                response = "nulll";
            }

            httpURLConnection.disconnect();

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

    }
}
