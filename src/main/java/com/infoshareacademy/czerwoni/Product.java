package com.infoshareacademy.czerwoni;

class Product {

    /* konwencja nazewnicza pól obiektu wynika ze specyfikacji
       obiektu JSON zwracanego przez API:
       http://www.produktywsieci.gs1.pl/apidocs/index#!/ApiProducts/ApiProducts_Get
    */
    private String GTIN;
    private String BrandOwner;
    private String Brand;
    private String Manufacturer;
    private String ProductName;
    private String Description;
    private String CountryOfOrigin;
    private String ProductImage;
    private String URL;
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
                //.append(" Product name: ")
                .append(ProductName)
                .append(" (brand name: ")
                .append(Brand)
                .append(", brand owner: ")
                .append(BrandOwner)
                .append(")")
                .toString();
    }
}
