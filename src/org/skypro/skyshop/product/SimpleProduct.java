package org.skypro.skyshop.product;

public class SimpleProduct extends Product {
    private int price;

    public SimpleProduct(String name, int price) {
        super(name);
        if (price <= 0) {
            throw new IllegalArgumentException("Цена продукта должны быть больше 0.");
        }
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}

