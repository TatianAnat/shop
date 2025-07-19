package org.skypro.skyshop;


import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;
import java.util.List;

public class App {
    public static void main(String[] args) {

        Product monitor = new Product("Монитор", 10500);
        Product printer = new Product("Принтер", 5200);
        Product keyboard = new Product("Клавиатура", 800);

        SearchEngine searchEngine = new SearchEngine();

        productBasket.addProduct(monitor);
        productBasket.addProduct(printer);
        productBasket2.addProduct(monitor);
        productBasket2.addProduct(keyboard);

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
            SimpleProduct p2 = new SimpleProduct("Принтер", 5200);
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
 * Создаём сценарий, где объект будет найден
 */
        try {
            String query1 = "Принтер";
            Searchable result1 = searchEngine.findBestMatch(query1, articles);
            System.out.println("Найден подходящий объект для запроса {" + query1 + "} " + result1);
        } catch (BestResultNotFound e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
        /**
         * Создаём сценарий, где объект будет не найден. Выбрасывается исключение
         */
        try {
            String query2 = "Колонки";
            Searchable result2 = searchEngine.findBestMatch(query2, articles);
            System.out.println("Найден подходящий объект для запроса {" + query2 + "} " + result2);
        } catch (BestResultNotFound e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        System.out.println();
        System.out.println("Корзина 1");
        productBasket.printProductBasket();
        System.out.println("Корзина 2");
        productBasket2.printProductBasket();
        System.out.println();
        List<Product> removed = productBasket.removeProductsByName("Монитор");
        System.out.println("Удалены товары из Корзины 1: ");
        for (Product p : removed) {
            System.out.println(p);
        }

