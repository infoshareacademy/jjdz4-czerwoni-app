package com.infoshareacademy.czerwoni.allegro;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class AllegroCategoryPrinterTest {


    @Test
    public void generateLink_GeneratedCorrectLink() {
        AllegroCategory allegroCategory = new AllegroCategory(1, "Motoryzacja", 10, 0);
        String link = allegroCategory.generateLink();

        assertThat(link)
                .isNotEmpty()
                .contains(allegroCategory.getCatName())
                .contains(Integer.toString(allegroCategory.getCatId()));
    }

    @Test
    public void generateLink_NotAllowedCharsReplaced() {
        AllegroCategory allegroCategory = new AllegroCategory(1, "Odzież, Obuwie, Dodatki", 20, 0);
        String link = allegroCategory.generateLink();

        assertThat(link)
                .doesNotContain(" ")
                .doesNotContain("ż")
                .contains("-")
                .contains("z");
    }
}
