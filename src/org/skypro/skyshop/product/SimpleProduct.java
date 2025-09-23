package org.skypro.skyshop.product;

public class SimpleProduct extends Product {
    private int price;

    public SimpleProduct(String productName, int price) {
        super(productName);
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public boolean isSpecial() {
        return false;
    }

    @Override
    public int getDiscount() {
        return 0;
    }
}
