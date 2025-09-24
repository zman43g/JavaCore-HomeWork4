package org.skypro.skyshop.product;

public class SimpleProduct extends Product {
    private final int price;

    public SimpleProduct(String productName, int price) {
        super(productName);
        if (price < 1) {
            throw new IllegalArgumentException("Цена должна быть больше 0");
        } else {
            this.price = price;
        }
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
