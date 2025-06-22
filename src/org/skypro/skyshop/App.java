package org.skypro.skyshop;

import org.skypro.skyshop.articles.Article;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;

import java.util.Arrays;
import java.util.List;

public class App {
    public static void main(String[] args) {
        ProductBasket productBasket = new ProductBasket(5); //корзина1 на 5 продуктов
        ProductBasket productBasket2 = new ProductBasket(5); //корзина2 на 5 продуктов
        SearchEngine searchEngine = new SearchEngine(10);
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

        searchEngine.add(apple);
        searchEngine.add(bread);
        searchEngine.add(milk);

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
        System.out.println();
        /**
         * Создаём и добавляем статьи
         */
        Article article1 = new Article("Яблоки", "Яблоки отличного качества, выращенные в садах Приволжья");
        Article article2 = new Article("Хлеб ЗОЖ", "Низкокалорийный хлеб из пророщенной пшеницы. Рекомендован людям, которые ведут здоровый образ жизни.");
        Article article3 = new Article("Польза молока", "Оно способствует укреплению костей и зубов, улучшает работу иммунной системы и пищеварения.");

        searchEngine.add(article1);
        searchEngine.add(article2);
        searchEngine.add(article3);
        /**
         * Поиск по запросам
         */
        searchAndPrint(searchEngine, "Яблоки");
        searchAndPrint(searchEngine, "Хлеб");
        searchAndPrint(searchEngine, "Молоко");
        searchAndPrint(searchEngine, "ЗОЖ");
        searchAndPrint(searchEngine, "принтер");

/**
 * очищаем Корзину № 1
 */
        productBasket.clear();
    }

    private static void searchAndPrint(SearchEngine engine, String query) {
        System.out.println("Результат поиска по запросу: " + query);
        Searchable[] results = engine.search(query);
        System.out.println(Arrays.toString(results));
        System.out.println();
    }
}