package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductBasket {
    private List<Product> products = new ArrayList<>();

    //Метод, который добавляет продукт в корзину void ничего не возвращает
    public void addProduct(Product product) {
        products.add(product);

    }

    // Метод для получения общей стоимости корзины
    public int getTotalCost() {
        int total = 0;
        for (Product product : products) {
            total += product.getProductPrice();
        }
        return total;
    }
}
