package com.infoshareacademy.czerwoni.product;

import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Map;

/**
 * rozpoznanie kodu kreskowego ze wskazanego pliku graficznego
 */
public class BarCodeReader {

    private static BarcodeFormat DEFAULT_BARCODE_FORMAT = BarcodeFormat.CODE_128;
    private static Logger logger = LoggerFactory.getLogger(BarCodeReader.class);

    /**
     * metoda odczytująca kod kreskowy z pliku graficznego przy wykorzystaniu biblioteki zxing
     *
     * @param imageFile   plik graficzny zawierający kod kreskowy do odczytania
     * @param decodeHints mapa ustawień dla wbudowanego w bibliotekę czytnika kodu
     * @return rozpoznany kod kreskowy
     * @throws Exception wyjątek braku pliku, problemu z jego odczytaniem; wyjątek niepomyślnego odczytania kodu kreskowego
     */
    private static String decodeBarcode(File imageFile, Map<DecodeHintType, Object> decodeHints) throws Exception {
        if ((imageFile == null) || (imageFile.getName().trim().isEmpty()))
            throw new IllegalArgumentException("Nie znaleziono pliku!");  //  "File not found or enetered incorrect name."


        BufferedImage bufferedImage;
        try {
            bufferedImage = ImageIO.read(imageFile);
        } catch (IOException e) {
            throw new Exception(e.getMessage());
        }
        if (bufferedImage == null)
            throw new IllegalArgumentException("Nieudany odczyt zawartości pliku: " + imageFile.getName());  // "Reading file failed..."
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
            logger.warn("BarCodeReader.decodeBarcode() : nie znaleziono kodu kreskowego", e);
            throw e;
        }

        return decodedBarcode;
    }

    /**
     * ogólna metoda odczytująca kod kreskowy z pliku graficznego
     * (obecnie odczytująca kod tylko przy pomocy biblioteki zxing, może być rozszerzona o inne biblioteki)
     *
     * @param fileName nazwa pliku (wraz ze scieżką) obrazka zawierajacego kod kreskowy
     * @return rozpoznany kod kreskowy
     */
    public static String decodeBarcodeFromFile(String fileName) {

        String barcodeString = "";

            Map<DecodeHintType, Object> decodeHintsMap = new EnumMap<>(DecodeHintType.class);
            decodeHintsMap.put(DecodeHintType.TRY_HARDER, Boolean.TRUE);
            decodeHintsMap.put(DecodeHintType.POSSIBLE_FORMATS, EnumSet.allOf(BarcodeFormat.class));
            decodeHintsMap.put(DecodeHintType.PURE_BARCODE, Boolean.FALSE);
        try {
            File imgFile = new File(fileName);
            barcodeString = decodeBarcode(imgFile, decodeHintsMap);
        } catch (Exception e) {
            String msg = e.getMessage() == null ? "Problem z odczytem pliku: " + fileName : e.getMessage();
            System.out.println(msg);
            logger.error(msg, e);
        }
        return barcodeString;
    }
}
