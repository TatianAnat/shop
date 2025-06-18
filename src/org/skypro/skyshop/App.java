package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;

import java.util.List;

public class App {
    public static void main(String[] args) {
        ProductBasket productBasket = new ProductBasket(5); //корзина1 на 5 продуктов
        ProductBasket productBasket2 = new ProductBasket(5); //корзина2 на 5 продуктов
/**
 * заполняем Корзину № 1
 */
        SimpleProduct apple = new SimpleProduct("Яблоко", 50);
        SimpleProduct bread = new SimpleProduct("Хлеб", 45);
        DiscountedProduct milk = new DiscountedProduct("Молоко", 100, 10);
        SimpleProduct egg = new SimpleProduct("Яйцо", 80);
        FixPriceProduct oil = new FixPriceProduct("Масло");
        SimpleProduct pear = new SimpleProduct("Груша", 25);

        SimpleProduct cheese = new SimpleProduct("Сыр", 90);
        DiscountedProduct washingPowder = new DiscountedProduct("Стиральный порошок", 270, 15);

        /**
         * Добавляем в Корзину № 1
         */

        productBasket.addProduct(apple);
        productBasket.addProduct(bread);
        productBasket.addProduct(milk);
        productBasket.addProduct(egg);
        productBasket.addProduct(oil);
        productBasket.addProduct(pear);

        productBasket2.addProduct(cheese);
        productBasket2.addProduct(washingPowder);

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
    }
}