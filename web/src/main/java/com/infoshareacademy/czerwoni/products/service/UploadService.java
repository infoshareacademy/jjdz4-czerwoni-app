package com.infoshareacademy.czerwoni.products.service;

import com.infoshareacademy.czerwoni.products.domain.FileInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.Part;
import java.io.*;

public class UploadService {

    private static final String TMP_DIR = "/tmp";
    private final static String BARCODE_DIR = System.getProperty("jboss.home.dir") + "/user-storage/barcodes"; //"../user-storage/barcodes";
    private static Logger LOGGER = LoggerFactory.getLogger(UploadService.class);

    public static String getStoragePath() {
        File directory = new File(BARCODE_DIR);

        return directory.exists() ? BARCODE_DIR :
                (directory.mkdirs() ? BARCODE_DIR : TMP_DIR);
    }

    public static String getFileName(final Part part) {
        final String partHeader = part.getHeader("content-disposition");

        LOGGER.trace("Nagłówek części = {}", partHeader);

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

    public static void saveFileIntoStorage(FileInfo fileInfo) throws IOException {
        OutputStream out = null;
        InputStream filecontent = null;

        try {
            out = new FileOutputStream(
                    new File(fileInfo.getFilePath() + File.separator + fileInfo.getFileName()));

            filecontent = fileInfo.getFilePart().getInputStream();

            int read;
            final byte[] bytes = new byte[1024];

            while ((read = filecontent.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }

            LOGGER.trace("Plik {} został przesłany do {}", fileInfo.getFileName(), fileInfo.getFilePath());
        } finally {
            if (out != null) {
                out.close();
            }

            if (filecontent != null) {
                filecontent.close();
            }
        }
    }
}
