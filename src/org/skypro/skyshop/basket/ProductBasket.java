package org.skypro.skyshop.basket;
import java.util.*;

import org.skypro.skyshop.product.Product;

public class ProductBasket {
    private final Map<String, List<Product>> productsByName;

    public ProductBasket() {
        productsByName = new HashMap<>();
    }

    /**
     * добавление продукта (сгруппированного по имени)
     */
    public void addProduct(Product product) {
        productsByName.computeIfAbsent(product.getName(), k -> new ArrayList<>()).add(product);
    }

    /**
     * очистка корзины
     */
    public void clear() {
        productsByName.clear();
    }

    /**
     * Метод для получения общей стоимости корзины используя Stream API
     */
    public int getTotalPrice() {
        return productsByName.values().stream()
                .flatMap(List::stream)
                .mapToInt(Product::getPrice)
                .sum();
    }

    /**
     * Метод, который печатает содержимое корзины
     */
    public void printProductBasket() {
        if (productsByName.isEmpty()) {
            System.out.println("В корзине пусто");
            return;
        }

        productsByName.values().stream()
                .flatMap(List::stream)
                .forEach(product -> System.out.println(product.getName() + ":" + product.getPrice()));

        System.out.println("Итого: " + getTotalPrice());
        System.out.println("Количество специальных продуктов: " + getSpecialCount());
    }

    /**
     * Приватный метод для подсчёта специальных продуктов
     */
    private long getSpecialCount() {
        return productsByName.values().stream()
                .flatMap(List::stream)
                .filter(Product::isSpecial)
                .count();
    }
    /**
     *   Метод проверки продукта в корзине по имени
     */
     public boolean hasProduct(List<Product> products, String name) {
            return products.stream()
                    .anyMatch(product -> product.getName().equalsIgnoreCase(name));
        }
    }
