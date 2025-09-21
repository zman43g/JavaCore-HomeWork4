
package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        Product[] product = new Product[5];
        product[0] = new Product("Сахар", 80);
        product[1] = new Product("Сыр", 900);
        product[2] = new Product("Молоко", 70);
        product[3] = new Product("Соль", 20);
        product[4] = new Product("Курица", 200);

        ProductBasket basket1 = new ProductBasket();

        basket1.addProduct(product[0]);
        basket1.addProduct(product[3]);
        basket1.addProduct(product[1]);
        basket1.addProduct(product[2]);
        basket1.addProduct(product[4]);
        basket1.addProduct(product[3]);


        basket1.printBasket();
        System.out.println("basket1.totalCost() = " + basket1.totalCost());

        System.out.println();
        System.out.println("Наличие продукта в корзине = " + basket1.checkInBasket("Сыр"));
        System.out.println("Наличие продукта в корзине = " + basket1.checkInBasket("Мясо"));

        basket1.emptyBasket();
        basket1.printBasket();
        System.out.println("basket1.totalCost() = " + basket1.totalCost());
        System.out.println("Наличие продукта в корзине = " + basket1.checkInBasket("Мясо"));

    }


}