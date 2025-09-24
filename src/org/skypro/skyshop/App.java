
package org.skypro.skyshop;

import org.skypro.skyshop.article.SearchEngine;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.exeptions.BestResultNotFound;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.article.Article;






public class App {
    public static void main(String[] args) throws BestResultNotFound {
        Product[] product = new Product[5];
        product[0] = new SimpleProduct("Сахар", 80);
        product[1] = new SimpleProduct("Сыр", 600);
        product[2] = new FixPriceProduct("Молоко", 70);
        product[3] = new SimpleProduct("Соль", 20);
        product[4] = new DiscountedProduct("Овсянка", 200, 40);


        ProductBasket basket1 = new ProductBasket();

        basket1.addProduct(product[0]);
        basket1.addProduct(product[3]);
        basket1.addProduct(product[1]);
        basket1.addProduct(product[2]);
        basket1.addProduct(product[4]);


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
        System.out.println();

        Article[] articles = new Article[5];
        articles[0] = new Article("О вреде соли", "Соль очень вредна в больших количествах!");
        articles[1] = new Article("О ПДД", "Необходимо соблюдать ПДД!");
        articles[2] = new Article("О пользе сна", "Крепкий сон полезен для здоровья.");

        System.out.println("article.searchTerm() = " + articles[0].searchTerm());
        System.out.println("article.getStringRepresentation() = " + articles[0].getStringRepresentation());
        System.out.println("product[0].searchTerm() = " + product[0].searchTerm());
        System.out.println("article.searchTerm() = " + articles[0].searchTerm());
        System.out.println("article.contentFound() = " + articles[0].contentFound());
        System.out.println();

        SearchEngine searcher = new SearchEngine(5);
        searcher.add(product[3]);
        searcher.add(product[2]);
        searcher.add(articles[1]);
        searcher.add(articles[2]);
        searcher.add(product[4]);


        String[] result = searcher.search("ПДД");
        for (String string : result) {
            if (string != null) {
                System.out.println(string);
            }
        }
        System.out.println();
        result = searcher.search("о");
        for (String string : result) {
            if (string != null) {
                System.out.println(string);
            }
        }
        System.out.println();
        result = searcher.search("Овсянка");
        for (String string : result) {
            if (string != null) {
                System.out.println(string);
            }
        }
        System.out.println();

        try {
            product[4] = new DiscountedProduct("Просроченное сало", 200, 400);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            product[2] = new SimpleProduct("Тестовый продукт", -20);
        } catch (IllegalArgumentException s) {
            System.out.println(s.getMessage());
        }

        String searchQuery = "Волк";
        try {
            System.out.println("searcher.bestMatch = " + searcher.bestMatch(searchQuery).getStringRepresentation());
        } catch (BestResultNotFound exception) {
            System.out.println(exception.getMessage());
        }
        searchQuery = "полезен";
        try {
            System.out.println("searcher.bestMatch = " + searcher.bestMatch(searchQuery).getStringRepresentation());
        } catch (BestResultNotFound e) {
            System.out.println(e.getMessage());
        }
    }

}