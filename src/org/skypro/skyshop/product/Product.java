package org.skypro.skyshop.product;

public abstract class Product {
    private String name;

    public Product(String name) {
        this.name = name;
        //this.price = price;
    }

    public String getName() {
        return name;
    }

    public abstract int getPrice();

   // @Override
   // public String toString() {
   //     return "Product{ " + name + ": " + " стоимость со скидкой = "  + getPrice() +'}';
   // }

    public boolean isSpecial() {
        return true;
    }
}
