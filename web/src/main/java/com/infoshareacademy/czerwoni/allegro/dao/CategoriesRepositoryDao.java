package com.infoshareacademy.czerwoni.allegro.dao;

import com.infoshareacademy.czerwoni.allegro.domain.AllegroCategory;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface CategoriesRepositoryDao {
    Map<AllegroCategory, Integer> deserialize() throws IOException, SAXException;
    List<AllegroCategory> getCategories(int parentId);
}