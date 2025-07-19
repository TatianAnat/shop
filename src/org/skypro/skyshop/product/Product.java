package org.skypro.skyshop.product;

import org.skypro.skyshop.search.Searchable;

public class Product implements Searchable {
    private String name;
    int price;

    public Product(String name, int price) {
        /**
         * Метод isBlank() используется для проверки, является ли строка пустой или нет. Пустая строка или строка, содержащая только пробелы, считается пустой.
         */
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Название продукта не может быть пустым, состоять только из пробелов или быть null.");
        }
        this.name = name;
        this.price = price;
    }

    public Product(String name) {
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Product{ " + name + ": " + " стоимость = " + price + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return name != null ? name.equals(product.name) : product.name == null;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    @Override
    public String getSearchTerm() {
        return "";
    }
}
