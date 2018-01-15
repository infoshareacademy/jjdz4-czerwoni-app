package com.infoshareacademy.czerwoni.product;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BarCodeReaderTest {


    @Test
    public void decodeBarcodeFromFile_FileExists() {
        assertThat(BarCodeReader.decodeBarcodeFromFile("/home/mm/kod.png"))
                .isEqualTo("5900084063241");

    }

    @Test
    public void decodeBarcodeFromFile_FileNotExists() {
        assertThat(BarCodeReader.decodeBarcodeFromFile("/home/abc/xyz.png"))
                .isEmpty();
    }

    @Test
    public void decodeBarcodeFromFile_EmptyArg() {
        assertThat(BarCodeReader.decodeBarcodeFromFile(""))
                .isEmpty();
    }

    @Test
    public void decodeBarcodeFromFile_NullArg() {
        assertThat(BarCodeReader.decodeBarcodeFromFile(null))
                .isEmpty();
    }
}
