package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;

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
        for (int i = 0; i < products.length; i++) {
            if ((products[i] != null)) {
                if (products[i].getDiscount() != 0 && products[i].isSpecial()) {
                    System.out.println(products[i].getProductName() + ": " + products[i].getPrice() + " скидка " + products[i].getDiscount() + "%");
                    specialProductsQuantity++;
                } else if (products[i].isSpecial()) {
                    System.out.println(products[i].getProductName() + ": Фиксированная цена " + products[i].getPrice());
                    specialProductsQuantity++;
                } else {
                    System.out.println(products[i].getProductName() + ": " + products[i].getPrice());
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



