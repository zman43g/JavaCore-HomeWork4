package org.skypro.skyshop.product;

public class Product {
    private String productName;
    private int cost;

    public Product(String productName, int cost) {
        this.productName = productName;
        this.cost = cost;
    }

    public int getCost() {
        return cost;
    }

    public String getProductName() {
        return productName;
    }

}
