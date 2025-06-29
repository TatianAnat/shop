package org.skypro.skyshop;

import org.skypro.skyshop.basket.Article;
import org.skypro.skyshop.exceptions.*;
import org.skypro.skyshop.product.Product;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        SearchEngine searchEngine = new SearchEngine();

        List<Searchable> articles = new ArrayList<>();
        articles.add(new Article("лазерный принтер"));
        articles.add(new Article("сенсорный монитор"));
        articles.add(new Article("беспроводная клавиатура"));
        /**
         * Пример, будет поймана ошибка, т.к. в названии пустая строка
         */
        try {
            Product p1 = new Product("");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        /**
         * Будет поймана ошибка, так как цена не может быть 0
         */
        try {
            SimpleProduct p2 = new SimpleProduct("Принтер",0);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        /**
         * Будет поймана ошибка, так как неверная базовая цена. Базовая цена не может быть отрицательной
         */
        try {
            DiscountedProduct p3 = new DiscountedProduct("Монитор",-10,50);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        /**
         * Будет поймана ошибка, так как задан неверный процент скидки. Скидка не должна превышать 100%
         */
        try {
            DiscountedProduct p4 = new DiscountedProduct("Клавиатура",100,150);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            String query1 = "принтер";
            Searchable result1 = searchEngine.findBestMatch(query1,articles);
            System.out.println("Найден подходящий объект для запроса " + query1 + ": " + result1);
        } catch (BestResultNotFound e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        try {
            String query2 = "Колонки";
            Searchable result2 = searchEngine.findBestMatch(query2,articles);
            System.out.println("Найден подходящий объект для запроса " + query2 + ": " + result2);
        } catch (BestResultNotFound e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
//        ProductBasket productBasket = new ProductBasket(5); //корзина1 на 5 продуктов
//        ProductBasket productBasket2 = new ProductBasket(5); //корзина2 на 5 продуктов
///**
// * заполняем Корзину № 1
// */
//        Product apple = new Product("Яблоко", 50);
//        Product bread = new Product("Хлеб", 45);
//        Product milk = new Product("Молоко", 100);
//        Product egg = new Product("Яйцо", 80);
//        Product oil = new Product("Масло", 30);
//        Product pear = new Product("Груша", 25);
//
//        /**
//         * Добавляем в Корзину № 1
//         */
//
//        productBasket.addProduct(apple);
//        productBasket.addProduct(bread);
//        productBasket.addProduct(milk);
//        productBasket.addProduct(egg);
//        productBasket.addProduct(oil);
//        productBasket.addProduct(pear);
//
//
///**
// * Печатаем содержимое Корзины № 1 и общую сумму
// */
//        System.out.println("Корзина № 1");
//        productBasket.printProductBasket();
//
///**
// * Печатаем содержимое Корзины № 2 и общую сумму
// */
//        System.out.println();
//        System.out.println("Корзина № 2");
//        productBasket2.printProductBasket();
//
//        System.out.println();
//        System.out.println(("Есть ли хлеб в корзине? " + productBasket.hasProduct("хлеб")));
//        System.out.println(("Есть ли мороженое в корзине? " + productBasket.hasProduct("мороженое")));
//
///**
// * очищаем Корзину № 1
// */
//        productBasket.clear();
//        productBasket.printProductBasket();

    }
}