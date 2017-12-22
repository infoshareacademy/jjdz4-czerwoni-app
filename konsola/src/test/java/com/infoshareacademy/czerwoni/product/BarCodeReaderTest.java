package com.infoshareacademy.czerwoni.product;

import org.junit.Test;

public class BarCodeReaderTest {

    private static final String PRINT_MSG = "Odczytany kod kreskowy: ";

    @Test
    public void decodeBarcodeFromFile_FileExists() {
        System.out.println(PRINT_MSG + BarCodeReader.decodeBarcodeFromFile("/home/mm/kod.png"));
    }

    @Test
    public void decodeBarcodeFromFile_FileNotExists() {
        System.out.println(PRINT_MSG + BarCodeReader.decodeBarcodeFromFile("/home/abc/xyz.png"));
    }

    @Test
    public void decodeBarcodeFromFile_EmptyArg() {
        System.out.println(PRINT_MSG + BarCodeReader.decodeBarcodeFromFile(""));
    }

    @Test
    public void decodeBarcodeFromFile_NullArg() {
        System.out.println(PRINT_MSG + BarCodeReader.decodeBarcodeFromFile(null));
    }
}
