package org.skypro.skyshop;

import org.skypro.skyshop.basket.Article;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.exceptions.*;
import org.skypro.skyshop.product.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class App {
    public static void main(String[] args) {

        ProductBasket basket = new ProductBasket();
        basket.addProduct(new SimpleProduct("Принтер Canon", 15000));
        basket.addProduct(new DiscountedProduct("Монитор Samsung", 20000, 10));
        basket.addProduct(new SimpleProduct("Клавиатура Logitech", 5000));

        SearchEngine searchEngine = new SearchEngine();
        /**
         * добавляем статьи в поисковый движок
         */
        searchEngine.addItem(new Article("лазерный принтер"));
        searchEngine.addItem(new Article("сенсорный монитор"));
        searchEngine.addItem(new Article("беспроводная клавиатура"));
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
            SimpleProduct p2 = new SimpleProduct("Принтер", 0);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        /**
         * Будет поймана ошибка, так как неверная базовая цена. Базовая цена не может быть отрицательной
         */
        try {
            DiscountedProduct p3 = new DiscountedProduct("Монитор", -10, 50);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        /**
         * Будет поймана ошибка, так как задан неверный процент скидки. Скидка не должна превышать 100%
         */
        try {
            DiscountedProduct p4 = new DiscountedProduct("Клавиатура", 100, 150);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
/**
 * Создаём сценарий, где объект будет найден (поиск лучшего совпадения среди статей)
 */
        try {
            String query1 = "Принтер";
            Searchable result1 = searchEngine.findBestMatch(query1, searchEngine.getItems());
            System.out.println("Найден подходящий объект для запроса {" + query1 + "} " + result1.getName());
        } catch (BestResultNotFound e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
        /**
         * Создаём сценарий, где объект будет не найден. Выбрасывается исключение
         */
        try {
            String query2 = "Колонки";
            Searchable result2 = searchEngine.findBestMatch(query2, searchEngine.getItems());
            System.out.println("Найден подходящий объект для запроса {" + query2 + "} " + result2.getName());
        } catch (BestResultNotFound e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
        /**
         * использование search - поиск всех подходящих результатов
         */
        String query3 = "монитор";
        Set<Searchable> foundResults = searchEngine.search(query3);

        System.out.println("Результат поиска по запросу \"" + query3 + "\":");
        if (foundResults.isEmpty()) {
            System.out.println("Результаты не найдены ");
        } else {
            for (Searchable s : foundResults) {
                System.out.println("- " + s.getName());
            }
        }


        System.out.println("Содержимое корзины: ");
        basket.printProductBasket();

        System.out.println("Общая стоимость корзины: " + basket.getTotalPrice());

    }
}