package com.infoshareacademy.czerwoni.product;

import org.junit.Test;

import java.io.File;

import static org.assertj.core.api.Assertions.assertThat;

public class BarCodeReaderTest {


    @Test
    public void decodeBarcodeFromFile_FileExists() {
        File imgFile = new File(this.getClass().getResource("/kod.png").getFile());
        assertThat(BarCodeReader.decodeBarcodeFromFile(imgFile.getAbsolutePath()))
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

}
