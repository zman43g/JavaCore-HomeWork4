package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;


import java.util.Arrays;

public class ProductBasket {
    private final Product[] products;

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

    public int totalPrice() {
        int total = 0;
        for (Product product : products) {
            if (product != null) {
                total = product.getPrice() + total;
            }
        }
        return total;
    }

    public void printBasket() {
        int aux = 0;//для проверки на наличие товаров в корзине
        int specialProductsQuantity = 0;
        for (Product product : products) {
            if ((product != null)) {
                if (product.getDiscount() != 0 && product.isSpecial()) {
                    System.out.println(product.getProductName() + ": " + product.getPrice() + " скидка " + product.getDiscount() + "%");
                    specialProductsQuantity++;
                } else if (product.isSpecial()) {
                    System.out.println(product.getProductName() + ": Фиксированная цена " + product.getPrice());
                    specialProductsQuantity++;
                } else {
                    System.out.println(product.getProductName() + ": " + product.getPrice());
                }
                aux = aux + 1;
            }
        }
        if (aux != 0) {
            System.out.println("Итого: " + totalPrice());
            System.out.println("Специальных товаров: " + specialProductsQuantity);
        } else {
            System.out.println("В корзине пусто");
        }

    }

    public boolean checkInBasket(String productName) {
        boolean checker = false;
        for (Product product : products) {
            if (product != null && product.getProductName().equals(productName)) {
                checker = true;
                break;
            }
        }
        return checker;
    }

    public void emptyBasket() {
        Arrays.fill(products, null);
    }

}



