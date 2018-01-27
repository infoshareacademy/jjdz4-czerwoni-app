package com.infoshareacademy.czerwoni.parse;

import com.infoshareacademy.czerwoni.allegro.AllegroCategory;
import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

public class ParseXmlAllegroCategoriesTest {

    @Test
    public void parseXml_ListNotEmpty() {
        List<AllegroCategory> categories = ParseXmlAllegroCategories.deserialization();
        assertThat(!categories.isEmpty());
    }

    @Test
    public void parseXml_ContainsCorrectData() {
        List<AllegroCategory> categories = ParseXmlAllegroCategories.deserialization();
        assertThat(categories.stream().filter(category -> category.getCatId()==5).findFirst().get().getCatId() == 5);
    }
}
