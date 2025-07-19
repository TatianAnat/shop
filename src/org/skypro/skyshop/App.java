package org.skypro.skyshop;

import org.skypro.skyshop.basket.Article;
import org.skypro.skyshop.exceptions.*;
import org.skypro.skyshop.product.Product;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class App {
    public static void main(String[] args) {
        SearchEngine searchEngine = new SearchEngine();

        searchEngine.addItem(new MySearchable("Принтер Canon"));
        searchEngine.addItem(new MySearchable("Монитор Apple"));
        searchEngine.addItem(new MySearchable("Клавиатура Microsoft"));
        searchEngine.addItem(new MySearchable("Принтер Epson"));

        Set<Searchable> results = searchEngine.search("Принтер");

        if (results.isEmpty()) {
            System.out.println("Результаты не найдены");
        } else {
            for (Searchable result : results) {
                System.out.println(result.getName());
            }
        }

        searchEngine.addItem(new Product("Принтер"));
        searchEngine.addItem(new Product("Монитор"));
        searchEngine.addItem(new Product("Клавиатура"));
        searchEngine.addItem(new Product("Принтер"));


        List<Searchable> articles = new ArrayList<>();
        articles.add(new Article("лазерный принтер"));
        articles.add(new Article("сенсорный монитор"));
        articles.add(new Article("беспроводная клавиатура"));
        articles.add(new Article("лазерный принтер"));

        System.out.println("Список товаров = " + articles);
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
/**
 * Создаём сценарий, где объект будет найден
 */
        try {
            String query1 = "Принтер";
            Searchable result1 = searchEngine.findBestMatch(query1,searchEngine.getItems());
            System.out.println("Найден подходящий объект для запроса {" + query1 + "} " + result1);
        } catch (BestResultNotFound e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
        /**
         * Создаём сценарий, где объект будет не найден. Выбрасывается исключение
         */
        try {
            String query2 = "Колонки";
            Searchable result2 = searchEngine.findBestMatch(query2,searchEngine.getItems());
            System.out.println("Найден подходящий объект для запроса {" + query2 + "} " + result2);
        } catch (BestResultNotFound e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

    }
}