package com.infoshareacademy.czerwoni;

class Product extends Object {

    // http://www.produktywsieci.gs1.pl/Subpage/FieldsScope
    private String GTIN;
    private String brandOwner;
    private String manufacturerName;
    private String brandName;
    private String itemName;
    private String description;
    private String countryOfOrigin;
    private String picture;
    private String URL;

    String getGTIN() {
        return GTIN;
    }

    void  setGTIN(String GTIN){
       this.GTIN = GTIN;
    }

    String getBrandOwner() {
        return brandOwner;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder
                .append(GTIN)
                .append(" - ")
                .append(itemName)
                .append(" - ")
                .append(description).toString();
    }
}
