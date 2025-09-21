
package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        Product[] product = new Product[5];
        product[0] = new SimpleProduct("Сахар", 80);
        product[1] = new SimpleProduct("Сыр", 900);
        product[2] = new FixPriceProduct("Молоко", 70);
        product[3] = new SimpleProduct("Соль", 20);
        product[4] = new DiscountedProduct("Курица", 200, 40);

        ProductBasket basket1 = new ProductBasket();

        basket1.addProduct(product[0]);
        basket1.addProduct(product[3]);
        basket1.addProduct(product[1]);
        basket1.addProduct(product[2]);
        basket1.addProduct(product[4]);
        basket1.addProduct(product[3]);

        basket1.printBasket();
        System.out.println("basket1.totalPrice() = " + basket1.totalPrice());

        System.out.println();
        System.out.println("Наличие продукта в корзине = " + basket1.checkInBasket("Сыр"));
        System.out.println("Наличие продукта в корзине = " + basket1.checkInBasket("Креветки"));

        basket1.emptyBasket();
        basket1.printBasket();
        System.out.println("basket1.totalPrice() = " + basket1.totalPrice());
        System.out.println("Наличие продукта в корзине = " + basket1.checkInBasket("Мясо"));
        DiscountedProduct discountedProduct = new DiscountedProduct("Сыр", 100, 50);
        System.out.println("Discounted = " + discountedProduct.getPrice());

    }
}