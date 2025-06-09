package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;

public class App {
    public static void main(String[] args) {
        ProductBasket productBasket = new ProductBasket();
        Product apple = new Product("Яблоко", 5);
        Product bread = new Product("Хлеб", 60);


        productBasket.addProduct(apple);
        productBasket.addProduct(bread);
    }
}