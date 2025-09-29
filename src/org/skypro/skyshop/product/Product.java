package org.skypro.skyshop.product;

import org.skypro.skyshop.article.Searchable;

public abstract class Product implements Searchable {
    private final String productName;

    public Product(String productName) {
        if (productName.isBlank()) {
            throw new IllegalArgumentException("Название продукта не должно быть пустым");

        } else {
            this.productName = productName;
        }
    }

    public abstract int getPrice();

    public abstract boolean isSpecial();

    public abstract int getDiscount();

    public String getProductName() {
        return productName;
    }

    @Override
    public String searchTerm() {
        return productName + " PRODUCT ";

    }

    @Override
    public String getStringRepresentation() {
        return " Имя " + productName + " Тип Searchable объекта PRODUCT ";
    }

    @Override
    public String contentFound() {
        return productName.getClass().getSimpleName();
    }

    @Override
    public String toString() {
        return productName;
    }

}

