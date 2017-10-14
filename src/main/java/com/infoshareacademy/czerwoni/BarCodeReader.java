package com.infoshareacademy.czerwoni;

import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Map;

class BarCodeReader {

    private static BarcodeFormat DEFAULT_BARCODE_FORMAT = BarcodeFormat.CODE_128;

    private static String decodeBarcode(File imageFile, Map<DecodeHintType, Object> decodeHints) throws Exception {
        if ((imageFile == null) || (imageFile.getName().trim().isEmpty()))
            throw new IllegalArgumentException("Plik nie znaleziony lub błedna nazwa.");

        BufferedImage bufferedImage;
        try {
            bufferedImage = ImageIO.read(imageFile);
        } catch (IOException e) {
            throw new Exception(e.getMessage());
        }
        if (bufferedImage == null)
            throw new IllegalArgumentException("Nie udało wczytać sie pliku...");
        LuminanceSource luminanceSource = new BufferedImageLuminanceSource(bufferedImage);


        BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(luminanceSource));
        MultiFormatReader multiFormatReader = new MultiFormatReader();
        Result tmpResult;
        String decodedBarcode;

        try {
            if (decodeHints != null && !decodeHints.isEmpty())
                tmpResult = multiFormatReader.decode(binaryBitmap, decodeHints);
            else
                tmpResult = multiFormatReader.decode(binaryBitmap);

            decodedBarcode = String.valueOf(tmpResult.getText());
        } catch (NotFoundException e) {
            throw new Exception("BarCodeReader.decodeBarcode - wyjątek: " + e.toString() + " - " + e.getMessage());
        }

        return decodedBarcode;
    }

    static String decodeBarcodeFromFile(String fileName) {
        String barcodeString = "";
        try {
            Map<DecodeHintType, Object> decodeHintsMap = new EnumMap<>(DecodeHintType.class);
            decodeHintsMap.put(DecodeHintType.TRY_HARDER, Boolean.TRUE);
            decodeHintsMap.put(DecodeHintType.POSSIBLE_FORMATS, EnumSet.allOf(BarcodeFormat.class));
            decodeHintsMap.put(DecodeHintType.PURE_BARCODE, Boolean.FALSE);

            File imgFile = new File(fileName);
            barcodeString = decodeBarcode(imgFile, decodeHintsMap);


        } catch (Exception e) {
            System.out.println("decodeBarcodeFromFile - " + "wyjątek: " + e.getMessage());
        }
        return barcodeString;
    }
}
