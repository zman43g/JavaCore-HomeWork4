package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;



import java.util.*;

public class ProductBasket {
    private Map<String, List<Product>> products = new HashMap<>();


    public ProductBasket() {
        this.products = new HashMap<>();
    }


    public void addProduct(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("Product cannot be null");
        }
        products.computeIfAbsent(product.getProductName(), k -> new ArrayList<>()).add(product);
    }


    public List<Product> removeProductFromBasket(String name) {
        int counter = 0;
        List<Product> removedProducts = new ArrayList<>();
        for (List<Product> productList : products.values()) {
            Iterator<Product> iterator = productList.iterator();
            while (iterator.hasNext()) {
                Product product = iterator.next();
                if (product.getProductName().equalsIgnoreCase(name)) {
                    counter++;
                    removedProducts.add(product);
                    iterator.remove();
                    System.out.println("Удалён продукт " + product.getProductName());
                }
            }


        }
        if (counter == 0) {
            System.out.println("Продукт с именем " + name + " в корзине не найден");
        }
        return removedProducts;
    }


    public int totalPrice() {
        int total = 0;
        for (List<Product> productList : products.values()) {
            for (Product product : productList) {
                total = total + product.getPrice();
            }
        }
        return total;
    }


    public void printBasket() {
        int aux = 0;//для проверки на наличие товаров в корзине
        int specialProductsQuantity = 0;
        for (List<Product> productList : products.values()) {
            for (Product product : productList) {
                if ((product.getProductName() != null)) {
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
        for (List<Product> productList : products.values()) {
            for (Product product : productList) {
                if (product != null && product.getProductName().equals(productName)) {
                    checker = true;
                    break;
                }
            }
        }
        return checker;
    }

    public void emptyBasket() {
        products.clear();
    }
}



