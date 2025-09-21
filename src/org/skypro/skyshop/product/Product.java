package org.skypro.skyshop.product;

public abstract class Product {
    private final String productName;

    public Product(String productName) {
        this.productName = productName;
    }
    public abstract int getPrice();

    public abstract boolean isSpecial();

    public abstract int getDiscount();

    public String getProductName() {
        return productName;
    }
}
