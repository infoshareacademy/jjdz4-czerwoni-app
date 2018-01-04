package com.infoshareacademy.czerwoni.domain;


import javax.persistence.*;

@Entity
class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private int categoryId;
    @Column(nullable = false)
    private String categoryName;
    private String categoryAllegroLink;
    @OneToOne
    private Answer relatedAnswer;

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

    public Answer getRelatedAnswer() {
        return relatedAnswer;
    }

    public void setRelatedAnswer(Answer relatedAnswer) {
        this.relatedAnswer = relatedAnswer;
    }
}
