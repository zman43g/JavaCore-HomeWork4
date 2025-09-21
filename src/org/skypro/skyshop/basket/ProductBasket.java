package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.Arrays;

public class ProductBasket {
    private Product[] products;

    public ProductBasket() {
        this.products = new Product[5];
    }

    public void addProduct(Product product) {
        int aux = 0;
        for (int i = 0; i < products.length; i++) {
            if (products[i] == null) {
                products[i] = product;
                aux = 1;
                break;
            }

        }
        if (aux == 0) {
            System.out.println("Невозможно добавить продукт");
        }
    }

    public int totalCost() {
        int total = 0;
        for (Product product : products) {
            if (product != null) {
                total = product.getCost() + total;
            }
        }
        return total;
    }

    public void printBasket() {
        int aux = 0;
        for (int i = 0; i < products.length; i++) {
            if (products[i] != null) {
                System.out.println(products[i].getProductName() + ": " + products[i].getCost());
                aux = aux + 1;
            }

        }
        if (aux != 0) {
            System.out.println("Итого: " + totalCost());
        } else {
            System.out.println("в корзине пусто");
        }

    }

    public boolean checkInBasket(String productName) {
        boolean checker = false;
        for (int i = 0; i < products.length; i++) {
            if (products[i] != null && products[i].getProductName() == productName) {
                checker = true;
            }
        }
        return checker;
    }

    public void emptyBasket() {
        Arrays.fill(products, null);
    }

}



