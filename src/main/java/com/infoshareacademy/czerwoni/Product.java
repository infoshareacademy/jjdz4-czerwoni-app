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
    private String picture;  // Link do marketingowego obrazka produktu w rozmiarze L (około 800x600)
    private String URL;      // Link do strony produktu, ewentualnie link do strony właściciela marki

    String getGTIN() {
        return GTIN;
    }

    void  setGTIN(String GTIN){
       this.GTIN = GTIN;
    }

    String getBrandOwner() {
        return brandOwner;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public String getBrandName() {
        return brandName;
    }

    public String getItemName() {
        return itemName;
    }

    public String getDescription() {
        return description;
    }

    public String getCountryOfOrigin() {
        return countryOfOrigin;
    }

    public String getPicture() {
        return picture;
    }

    public String getURL() {
        return URL;
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
