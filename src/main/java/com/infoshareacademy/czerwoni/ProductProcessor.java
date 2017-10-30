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
import java.util.Scanner;

/**
 * klasa obsługująca przetwarzanie produktu: odczytanie kodu kreskowego ze wskazanego pliku
 * oraz pobranie danych produktu z API na podstawie odczytanego kodu
 */
class ProductProcessor {


    /**
     * metoda pobierająca dane produktu z webowego interfejsu API
     * na podstawie jego kodu kreskowego
     *
     * @param barcode kod kreskowy produktu
     * @return szczegółowe informacje na temat odczytanego produktu
     */
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

            Gson gson = new Gson();
            // Product product = gson.fromJson(in, Product.class);
            Product product = gson.fromJson(respJSON, Product.class);

            if (product != null) {
                response = product.toString();
            } else {
                response = "null product";
            }
            response = response + "\n";

            httpURLConnection.disconnect();

        } catch (MalformedURLException e) {
            System.out.println("Malformed URL has occurred");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;

    }

    /**
     * metoda odczytuje kod kreskowy ze wskaznego pliku, następnie wysyła zapytanie do API,
     * i wyświetla informacje o zwróconym produkcie
     *
     */
    static void identifyProductFromImage() {
        System.out.println("Podaj nazwę pliku z kodem kreskowym: ");  // "Please enter path and filename: "
        Scanner pathScanner = new Scanner(System.in);
        String imageFilename = pathScanner.nextLine();

        String productBarcode = BarCodeReader.decodeBarcodeFromFile(imageFilename);
        if (productBarcode.isEmpty()) {
            System.out.println("Nie znaleziono kodu kreskowego\n");  // // "No barcode found/decoded\n"
        } else {
            System.out.println("Odczytany kod kreskowy: " + productBarcode);  // "Decoded barcode: "
            System.out.println("Zidentyfikowany produkt: " + getProductDataFromAPI(productBarcode));  // "Product found: "
        }
        System.out.println("Naciśnij Enter aby wrócić do menu");
        pathScanner.nextLine();
    }
}
