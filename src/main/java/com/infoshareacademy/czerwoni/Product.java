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
    // private BinaryBitmap image

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
