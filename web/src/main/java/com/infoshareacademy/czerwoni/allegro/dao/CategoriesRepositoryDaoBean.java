package com.infoshareacademy.czerwoni.allegro.dao;

import com.infoshareacademy.czerwoni.allegro.domain.AllegroCategory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Stateless
public class CategoriesRepositoryDaoBean implements CategoriesRepositoryDao {

    @EJB
    CategoriesRepositoryDao categoriesRepositoryDao;

    @Override
    public Map<AllegroCategory, Integer> deserialize() throws IOException, SAXException {
        InputStream xmlStream = this.getClass().getClassLoader().getResourceAsStream("Allegro_cathegories_2016-02-13.xml");
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = null;
        try {
            documentBuilder = documentBuilderFactory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        Document document;
        document = documentBuilder.parse(xmlStream);
        document.getDocumentElement().normalize();
        NodeList nodeList = document.getElementsByTagName("ns1:item");
        List<AllegroCategory> allegroCategories = new ArrayList<>();
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            Element element = (Element) node;
            allegroCategories.add(new AllegroCategory(
                    Integer.parseInt(element.getElementsByTagName("ns1:catId").item(0).getTextContent()),
                    element.getElementsByTagName("ns1:catName").item(0).getTextContent(),
                    Integer.parseInt(element.getElementsByTagName("ns1:catPosition").item(0).getTextContent()),
                    Integer.parseInt(element.getElementsByTagName("ns1:catParent").item(0).getTextContent())));
        }
        Map<AllegroCategory, Integer> categoriesMap = null;
        for (AllegroCategory category: allegroCategories) {
            categoriesMap.put(category, category.getCatParent());
        }
        return  categoriesMap;
    }

    @Override
    public List<AllegroCategory> getCategories(int parentId) {
        Map<AllegroCategory, Integer> allCategories = null;
        try {
            allCategories = categoriesRepositoryDao.deserialize();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }

        return allCategories.entrySet().stream()
                .filter(category -> category.getValue() == parentId)
                .map(category -> category.getKey())
                .collect(Collectors.toList());
    }
}
