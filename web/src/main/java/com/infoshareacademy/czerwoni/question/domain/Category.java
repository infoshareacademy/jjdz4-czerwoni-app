package com.infoshareacademy.czerwoni.question.domain;


import javax.persistence.*;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private int categoryId;
    @Column(nullable = false)
    private String categoryName;
    private String categoryAllegroLink;

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryAllegroLink() {
        return categoryAllegroLink;
    }

    public void setCategoryAllegroLink(String categoryAllegroLink) {
        this.categoryAllegroLink = categoryAllegroLink;
    }

}
