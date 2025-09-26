package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;


import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ProductBasket {
    private final List<Product> products;

    public ProductBasket() {
        this.products = new LinkedList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public List<Product> removeProductFromBasket(String name) {
        List<Product> removedProducts = new LinkedList<>();
        Iterator<Product> iterator = products.iterator();
        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product.getProductName().equals(name)) {
                removedProducts.add(product);
                iterator.remove();
            }
        }
        if (!removedProducts.isEmpty()) {
            for (Product p : removedProducts) {
                System.out.println("Удален продукт из корзины: " + p.getProductName());
            }
        } else {
            System.out.println("Список удаленных продуктов пуст");
        }
        return removedProducts;
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
        Collections.fill(products, null);
    }
}



