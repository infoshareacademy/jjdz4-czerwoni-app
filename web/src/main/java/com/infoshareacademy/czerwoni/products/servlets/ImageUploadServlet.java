package com.infoshareacademy.czerwoni.products.servlets;


import com.infoshareacademy.czerwoni.product.BarCodeReader;
import com.infoshareacademy.czerwoni.product.ProductProcessor;
import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;
import java.util.UUID;


@WebServlet("/FileUpload")

@MultipartConfig

public class ImageUploadServlet extends HttpServlet {

    private static Logger LOGGER = LoggerFactory.getLogger(ProductProcessor.class);
    private String fileName;
    private String filePath;
    private Part filePart;
    private String errMsg;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/product-info.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Servlet that uploads files with barcodes";
    }


    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final String GENERIC_ERR_MSG = "Albo nie wskazałeś pliku do przesłania, albo "
                + "próbujesz go zapisać w nieistniejącej lub niedostępnej "
                + "lokalizacji.";

        try {
            fetchDataFromRequest(request);
            saveFileIntoStorage(filePath, fileName, filePart);
            prepareOutData(request);

        } catch (FileNotFoundException fne) {
            errMsg = fne.getMessage().equals("") ? GENERIC_ERR_MSG : fne.getMessage();
            request.setAttribute("errMsg", errMsg);

            LOGGER.error("Problemy w trakcie przesyłu pliku. Błąd: {0}",
                    new Object[]{fne.getMessage()});
        }
    }

    private void prepareOutData(HttpServletRequest request) {

        String productBarcode = BarCodeReader.decodeBarcodeFromFile(filePath + "/" + fileName);
        if (productBarcode.isEmpty()) {
            errMsg = "Nie znaleziono kodu kreskowego";
            request.setAttribute("errMsg", errMsg);
            LOGGER.warn(errMsg);
        } else {
            Object foundProduct = ProductProcessor.getProductFromAPI(productBarcode);
            if (foundProduct == null) {
                errMsg = "Nie znaleziono produktu dla kodu: " + productBarcode;
                request.setAttribute("errMsg", errMsg);
                LOGGER.warn(errMsg);
            } else {
                LOGGER.trace("odczytany kod: " + productBarcode + "; produkt: " + foundProduct.toString());
                request.setAttribute("product", foundProduct);
            }
        }
    }

    private void fetchDataFromRequest(HttpServletRequest request) throws ServletException, IOException {
        filePart = request.getPart("file");
        if (filePart.getSubmittedFileName().equals(""))
            throw new FileNotFoundException("Podano pustą nazwę pliku z kodem kreskowym");
        filePath = getStoragePath();
        fileName = UUID.randomUUID().toString();

        String extension = FilenameUtils.getExtension(getFileName(filePart));
        if (!extension.isEmpty()) {
            fileName = fileName + "." + extension;
        }
    }

    private static String getStoragePath() {
        final String BARCODE_DIR = "../user-storage/barcodes";
        final String TMP_DIR = "/tmp";

        File directory = new File(BARCODE_DIR);

        return directory.exists() ? BARCODE_DIR :
                (directory.mkdirs() ? BARCODE_DIR : TMP_DIR);
    }

    private static void saveFileIntoStorage(String path, String fileName, Part filePart) throws IOException {
        OutputStream out = null;
        InputStream filecontent = null;

        try {
            out = new FileOutputStream(
                    new File(path + File.separator + fileName));

            filecontent = filePart.getInputStream();

            int read = 0;
            final byte[] bytes = new byte[1024];

            while ((read = filecontent.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }

            LOGGER.trace(
                    "Plik {0} został przesłany do {1}",
                    new Object[]{fileName, path});
        } finally {
            if (out != null) {
                out.close();
            }

            if (filecontent != null) {
                filecontent.close();
            }
        }
    }


    private String getFileName(final Part part) {
        final String partHeader = part.getHeader("content-disposition");

        LOGGER.trace("Nagłówek części = {0}", partHeader);

        for (String content : part.getHeader("content-disposition")
                .split(";")) {
            if (content.trim()
                    .startsWith("filename")) {
                return content.substring(content.indexOf('=') + 1)
                        .trim()
                        .replace("\"", "");
            }

        }
        return null;
    }

}