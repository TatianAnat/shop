package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;

import java.util.List;

public class App {
    public static void main(String[] args) {
        ProductBasket productBasket = new ProductBasket(5); //корзина1 на 5 продуктов
        ProductBasket productBasket2 = new ProductBasket(5); //корзина2 на 5 продуктов
/**
 * заполняем Корзину № 1
 */
        Product apple = new Product("Яблоко", 50);
        Product bread = new Product("Хлеб", 45);
        Product milk = new Product("Молоко", 100);
        Product egg = new Product("Яйцо", 80);
        Product oil = new Product("Масло", 30);
        Product pear = new Product("Груша", 25);

        /**
         * Добавляем в Корзину № 1
         */

        productBasket.addProduct(apple);
        productBasket.addProduct(bread);
        productBasket.addProduct(milk);
        productBasket.addProduct(egg);
        productBasket.addProduct(oil);
        productBasket.addProduct(pear);

/**
 * Печатаем содержимое Корзины № 1 и общую сумму
 */
        System.out.println("Корзина № 1");
        productBasket.printProductBasket();

/**
 * Печатаем содержимое Корзины № 2 и общую сумму
 */
        System.out.println();
        System.out.println("Корзина № 2");
        productBasket2.printProductBasket();

        System.out.println();
        System.out.println(("Есть ли хлеб в корзине? " + productBasket.hasProduct("хлеб")));
        System.out.println(("Есть ли мороженое в корзине? " + productBasket.hasProduct("мороженое")));

/**
 * очищаем Корзину № 1
 */
        productBasket.clear();
        productBasket.printProductBasket();

    }
}