package com.infoshareacademy.czerwoni;

class Product extends Object {

    // http://www.produktywsieci.gs1.pl/Subpage/FieldsScope  http://www.produktywsieci.gs1.pl/apidocs/index#!/ApiProducts/ApiProducts_Get
    private String GTIN;
    private String brandOwner;
    private String manufacturerName;
    private String brandName;
    private String itemName;
    private String description;
    private String countryOfOrigin;
    private String productImage;  // Link do marketingowego obrazka produktu w rozmiarze L (około 800x600)
    private String URL;      // Link do strony produktu, ewentualnie link do strony właściciela marki

    public Product(String GTIN, String brandOwner, String manufacturerName, String brandName, String itemName, String description, String countryOfOrigin, String productImage, String URL) {
        this.GTIN = GTIN;
        this.brandOwner = brandOwner;
        this.manufacturerName = manufacturerName;
        this.brandName = brandName;
        this.itemName = itemName;
        this.description = description;
        this.countryOfOrigin = countryOfOrigin;
        this.productImage = productImage;
        this.URL = URL;
    }

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

    public String getProductImage() {
        return productImage;
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
