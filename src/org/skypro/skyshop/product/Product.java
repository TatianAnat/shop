package org.skypro.skyshop.product;

public abstract class Product {
    private String name;

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public abstract int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Product{ " + name + ": " + " стоимость = " + price + '}';
    }
}
