package com.infoshareacademy.czerwoni.product;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BarCodeReaderTest {

    private static final String PRINT_MSG = "Odczytany kod kreskowy: ";

    @Test
    public void decodeBarcodeFromFile_FileExists() {
        // System.out.println(PRINT_MSG + BarCodeReader.decodeBarcodeFromFile("/home/mmil/kod.png"));
        // Odczytany kod kreskowy: 5900084063241
        assertThat(BarCodeReader.decodeBarcodeFromFile("/home/mmil/kod.png"))
                .contains("5900084063241");  // containsExactly

    }

    @Test
    public void decodeBarcodeFromFile_FileNotExists() {
        // System.out.println(PRINT_MSG + BarCodeReader.decodeBarcodeFromFile("/home/abc/xyz.png"));
        assertThat(BarCodeReader.decodeBarcodeFromFile("/home/abc/xyz.png"))
                .containsOnlyOnce("");
    }

    @Test
    public void decodeBarcodeFromFile_EmptyArg() {
        // System.out.println(PRINT_MSG + BarCodeReader.decodeBarcodeFromFile(""));
        assertThat(BarCodeReader.decodeBarcodeFromFile(""))
                .containsOnlyOnce("");
    }

    @Test
    public void decodeBarcodeFromFile_NullArg() {
        // System.out.println(PRINT_MSG + BarCodeReader.decodeBarcodeFromFile(null));
        assertThat(BarCodeReader.decodeBarcodeFromFile(null))
                .containsOnlyOnce("");
    }
}
