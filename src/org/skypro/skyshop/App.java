package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;

public class App {
    public static void main(String[] args) {
        ProductBasket productBasket = new ProductBasket(5); //корзина на 5 продуктов

        Product apple = new Product("Яблоко", 50);
        Product bread = new Product("Хлеб", 45);
        Product milk = new Product("Молоко", 100);


        productBasket.addProduct(apple);
        productBasket.addProduct(bread);
        productBasket.addProduct(milk);

        productBasket.printProductBasket();

        System.out.println(("Есть ли хлеб в корзине? " + productBasket.hasProduct("Хлеб")));
        System.out.println(("Есть ли мороженое в корзине? " + productBasket.hasProduct("Мороженое")));

        productBasket.clear();
        productBasket.printProductBasket();

    }
}