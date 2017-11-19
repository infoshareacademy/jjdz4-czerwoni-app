package com.infoshareacademy.czerwoni.category;

import com.infoshareacademy.czerwoni.parse.ParseXML;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;

/**
 * Klasa opisuje kategorie z pliku XML
 */
class Category {
    private int categoryId;
    private int categoryParent;
    private int categoryPosition;
    private boolean categoryVisible;
    private String categoryName;
    private int categoryGoToId;
    private int categoryAnswerId;
    private String categoryAllegroLink;

    int getCategoryId() {
        return categoryId;
    }

    void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    int getCategoryParent() {
        return categoryParent;
    }

    void setCategoryParent(int categoryParent) {
        this.categoryParent = categoryParent;
    }

    int getCategoryPosition() {
        return categoryPosition;
    }

    void setCategoryPosition(int categoryPosition) {
        this.categoryPosition = categoryPosition;
    }

    boolean isCategoryVisible() {
        return categoryVisible;
    }

    void setCategoryVisible(boolean categoryVisible) {
        this.categoryVisible = categoryVisible;
    }

    String getCategoryName() {
        return categoryName;
    }

    int getCategoryGoToId() {
        return categoryGoToId;
    }

    void setCategoryGoToId(int categoryGoToId) {
        this.categoryGoToId = categoryGoToId;
    }

    int getCategoryAnswerId() {
        return categoryAnswerId;
    }

    void setCategoryAnswerId(int categoryAnswerId) {
        this.categoryAnswerId = categoryAnswerId;
    }

    void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    String getCategoryAllegroLink() {
        return categoryAllegroLink;
    }

    void setCategoryAllegroLink(String categoryAllegroLink) {
        this.categoryAllegroLink = categoryAllegroLink;
    }

    /**
     *Metoda pobiera dokument XML(obiekt klasy Document)i zwraca listę obiektów klasy Category - wszystkich kategorii z pliku XML
     * @return Lista obiektó klasy Category
     */
    ArrayList<Category> getCategoryList() {
        ArrayList<Category> categoryArrayList = new ArrayList<>();
        ParseXML docXML = new ParseXML("src/main/resources/Categories.xml");
        Document doc = docXML.getXMLDocument();
        NodeList categoryNodeList = doc.getElementsByTagName("cat-item");
        for (int k = 0; k < categoryNodeList.getLength(); k++) {
            Category category = new Category();
            Node categoryItem = categoryNodeList.item(k);
            Element catItemElement = (Element) categoryItem;
            NodeList categoryDetailNodeList = catItemElement.getChildNodes();
            for (int i = 0; i < categoryDetailNodeList.getLength(); i++) {
                Node categoryDetailNode = categoryDetailNodeList.item(i);
                if (categoryDetailNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element catDetailElement = (Element) categoryDetailNode;
                    switch (catDetailElement.getTagName()) {
                        case "cat-item-id":
                            category.setCategoryId(Integer.parseInt(catDetailElement.getTextContent()));
                            break;
                        case "cat-item-name":
                            category.setCategoryName(catDetailElement.getTextContent());
                            break;
                        case "cat-item-parent":
                            category.setCategoryParent(Integer.parseInt(catDetailElement.getTextContent()));
                            break;
                        case "cat-item-position":
                            category.setCategoryPosition(Integer.parseInt(catDetailElement.getTextContent()));
                            break;
                        case "cat-item-visible":
                            category.setCategoryVisible(Boolean.parseBoolean(catDetailElement.getTextContent()));
                            break;
                        case "cat-goto-id":
                            category.setCategoryGoToId(Integer.parseInt(catDetailElement.getTextContent()));
                            break;
                        case "cat-item-answer-id":
                            category.setCategoryAnswerId(Integer.parseInt(catDetailElement.getTextContent()));
                            break;
                        case "cat-item-link":
                            category.setCategoryAllegroLink(catDetailElement.getTextContent());
                            break;
                    }
                }

            }

            categoryArrayList.add(category);

        }
        return categoryArrayList;
    }

}
