package com.infoshareacademy.czerwoni.product;

import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;
import java.util.Scanner;

import static java.net.HttpURLConnection.HTTP_OK;

/**
 * klasa obsługująca przetwarzanie produktu: odczytanie kodu kreskowego ze wskazanego pliku
 * oraz pobranie danych produktu z API na podstawie odczytanego kodu
 */
public class ProductProcessor {

    private static HttpURLConnection httpURLConnection;
    private static Logger logger = LoggerFactory.getLogger(ProductProcessor.class);
    private static String FOUND_PRODUCT_MSG = "Zidentyfikowany produkt: ";

    /**
     * metoda pobierająca dane produktu z webowego interfejsu API
     * na podstawie jego kodu kreskowego
     *
     * @param barcode kod kreskowy produktu
     * @return szczegółowe informacje na temat odczytanego produktu
     */
    static String getProductDescFromAPI(String barcode) {
        Product product = getProductFromAPI(barcode);
        return (product == null) ? "" : product.toString() + "\n";
    }

    /**
     * metoda odczytuje kod kreskowy ze wskaznego pliku, następnie wysyła zapytanie do API,
     * i wyświetla informacje o zwróconym produkcie
     *
     */
    public static void identifyProductFromImage() {

        logger.info("uruchomiono identyfikację produktu na podst. kodu kreskowego");
        System.out.println("Podaj nazwę pliku z kodem kreskowym: ");  // "Please enter path and filename: "
        Scanner pathScanner = new Scanner(System.in);
        String imageFilename = pathScanner.nextLine();

        String productBarcode = BarCodeReader.decodeBarcodeFromFile(imageFilename);
        printProductDescription(productBarcode);

        System.out.println("Naciśnij Enter aby wrócić do menu");
        pathScanner.nextLine();
    }

    private static void printProductDescription(String productBarcode) {
        if (productBarcode.isEmpty()) {
            String msg = "Nie znaleziono kodu kreskowego\n";
            System.out.println(msg);
            logger.error(msg);
        } else {
            System.out.println("Odczytany kod kreskowy: " + productBarcode);  // "Decoded barcode: "
            String productData = getProductDescFromAPI(productBarcode);
            System.out.println(FOUND_PRODUCT_MSG + productData);  // "Product found: "
            logger.trace("odczytany kod: " + productBarcode + "; produkt: " + productData);
        }
    }

    static public Product getProductFromAPI(String barcode) {
        Product product = null;

        if (connectToAPI(barcode)) {
            product = fetchDataFromAPI();
            httpURLConnection.disconnect();
        }

        return product;
    }

    private static Product fetchDataFromAPI() {
        Product product;
        InputStream content;
        String respJSON = "";

        try {
            content = httpURLConnection.getInputStream();
            BufferedReader in =
                    new BufferedReader(new InputStreamReader(content));
            respJSON = in.readLine();
        } catch (IOException e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        }

        Gson gson = new Gson();
        product = gson.fromJson(respJSON, Product.class);
        return product;
    }

    static private boolean connectToAPI(String barcode) {
        boolean isConnected = false;

        try {
            String webAPI = "http://www.produktywsieci.gs1.pl/api/products/" + barcode + "?aggregation=SOCIAL";
            final String authName = "mateusz@infoshareacademy.com",
                    authToken = "cc2ef9333d20dbd97bfb395e1f82fd3b4e5ef8a1e1be37598ba60faf2256efac";
            final String authString = authName + ":" + authToken;
            final String authEncoding = Base64.getEncoder().encodeToString((authString).getBytes("UTF-8"));

            URL urlAPI = new URL(webAPI);
            httpURLConnection = (HttpURLConnection) urlAPI.openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setRequestProperty("Accept", "text/json"); // "text/json"  "application/json"
            httpURLConnection.setRequestProperty("Authorization", "Basic " + authEncoding);

            isConnected = (httpURLConnection.getResponseCode() == HTTP_OK);

            String response = (isConnected ? "success (" : "failed (HTTP error code : ")
                    + httpURLConnection.getResponseCode() + "-" + httpURLConnection.getResponseMessage() + ")";
            logger.debug("connection to: " + webAPI + ", response: " + httpURLConnection.getResponseCode() + "-" + httpURLConnection.getResponseMessage());
        } catch (IOException e) {
            logger.error(e.getMessage());
        } finally {
            return isConnected;
        }
    }
}
