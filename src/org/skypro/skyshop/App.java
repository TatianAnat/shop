package org.skypro.skyshop;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.exceptions.*;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) {

        Product monitor = new Product("Монитор", 10500);
        Product printer = new Product("Принтер", 5200);
        Product keyboard = new Product("Клавиатура", 800);

        SearchEngine searchEngine = new SearchEngine();
        // List<Searchable> articles = new ArrayList<>();
        searchEngine.addItem(new MySearchable("принтер лазерный"));
        searchEngine.addItem(new MySearchable("сенсорный монитор"));
        searchEngine.addItem(new MySearchable("беспроводная клавиатура"));
        productBasket.addProduct(monitor);
        productBasket.addProduct(printer);
        productBasket2.addProduct(monitor);
        productBasket2.addProduct(keyboard);


        Map<String, Searchable> results = searchEngine.search("принтер");

        if (results.isEmpty()) {
            System.out.println("Результаты не найдены");
        } else {
            System.out.println("Найденные результаты: ");
            for (Map.Entry<String, Searchable> entry : results.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        }


         /**
         * Пример, будет поймана ошибка, т.к. в названии пустая строка
         */
        try {
            Product p1 = new Product("Принтер");
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

            System.out.println("Найден подходящий объект для запроса {" + query1 + "} " + result1);
        } catch (BestResultNotFound e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
        /**
         * Создаём сценарий, где объект будет не найден. Выбрасывается исключение
         */
        try {
            String query2 = "Колонки";
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
        /**
         * Проверяем, если захотим удалить тот товар, которого нет, то выведется сообщение, что "Список пуст"
         */
        System.out.println();
        List<Product> removedNonExist = productBasket.removeProductsByName("Коврик");
        if (removedNonExist.isEmpty()) {
            System.out.println("Список пуст");
        } else {
            System.out.println("Удалены товары из Корзины 1: ");
            for (Product p : removedNonExist) {
                System.out.println(p);
            }

        System.out.println();
        System.out.println("Корзина 1");
        productBasket.printProductBasket();
        System.out.println("Корзина 2");
        productBasket2.printProductBasket();

