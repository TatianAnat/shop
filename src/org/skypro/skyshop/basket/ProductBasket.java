package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

public class ProductBasket {
    private Product[] products;
    private int size; // количество добавленных продуктов

    public ProductBasket(int basket) {
        products = new Product[basket];
        size = 0;
    }
    //Метод, который добавляет продукт в корзину void ничего не возвращает
    public void addProduct(Product product) {
       if (size < products.length) {
           products[size] = product;
           size++;
       } else {
           System.out.println("Корзина заполнена, невозможно добавить продукт.");
       }
    }

    // Метод для получения общей стоимости корзины
    public int getTotalPrice() {
        int total = 0;
        for (int i = 0; i < size; i++) {
            total += products[i].getPrice();
        }
        return total;
}

    // Метод, который печатает содержимое корзины
    public void printProductBasket() {
        if (size == 0) {
            System.out.println("в корзине пусто");
            return;
        }
        for (int i = 0; i < size; i++) {
            System.out.println(products[i].getName() + ": " + products[i].getPrice());
        }
        System.out.println("Итого: " + getTotalPrice());
    }

    // Метод проверки продукта в корзине по имени
    public boolean hasProduct(String name) {
        for (int i = 0; i < size; i++) {
            if (products[i].getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    // Метод очистки корзины (проставляет null всем элементам массива)
    public void clear() {
        for (int i = 0; i < products.length; i++) {
            products[i] = null;
        }
        size = 0;
    }


}



