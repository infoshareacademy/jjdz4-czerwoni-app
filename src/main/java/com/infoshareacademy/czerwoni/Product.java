package com.infoshareacademy.czerwoni;

class Product extends Object {

    // http://www.produktywsieci.gs1.pl/Subpage/FieldsScope
    // http://www.produktywsieci.gs1.pl/apidocs/index#!/ApiProducts/ApiProducts_Get
    // {"GTIN":"05900084063241","BrandOwner":"McCORMICK POLSKA S.A.","Brand":"Kamis","Manufacturer":null,
    // "ProductName":"Kamis Musztarda grillowa 290 g","Description":null,"CountryOfOrigin":null,"ProductImage":"http://www.produktywsieci.pl/picture_cache/103/590/0084/05900084063241_MARKT_L.jpg","URL":"http://www.kamis.pl","IsLegal":true,"ModifiedDate":"2017-10-13T22:02:10.657"}
    private String GTIN;
    private String BrandOwner;
    private String Brand;
    private String Manufacturer;
    private String ProductName;
    private String Description;
    private String CountryOfOrigin;
    private String ProductImage;  // Link do marketingowego obrazka produktu w rozmiarze L (około 800x600)
    private String URL;           // Link do strony produktu, ewentualnie link do strony właściciela marki
    private boolean IsLegal;
    private String ModifiedDate;

    public Product(String GTIN, String brandOwner, String manufacturerName, String brandName, String productName) {
        this.GTIN = GTIN;
        this.BrandOwner = brandOwner;
        this.Manufacturer = manufacturerName;
        this.Brand = brandName;
        this.ProductName = productName;
    }

    String getGTIN() {
        return GTIN;
    }

    void setGTIN(String GTIN) {
        this.GTIN = GTIN;
    }

    String getBrandOwner() {
        return BrandOwner;
    }

    public String getManufacturer() {
        return Manufacturer;
    }

    public String getBrand() {
        return Brand;
    }

    public String getProductName() {
        return ProductName;
    }

    public String getDescription() {
        return Description;
    }

    public String getCountryOfOrigin() {
        return CountryOfOrigin;
    }

    public String getProductImage() {
        return ProductImage;
    }

    public String getURL() {
        return URL;
    }

    public boolean isLegal() {
        return IsLegal;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder
                .append(GTIN)
                .append(" Product name: ")
                .append(ProductName)
                .append(", brand owner: ")
                .append(BrandOwner)
                .append(", brand name: ")
                .append(Brand)
                .toString();
    }
}
