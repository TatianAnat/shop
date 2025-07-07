package org.skypro.skyshop.basket;


import org.skypro.skyshop.product.Product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductBasket {
    private List<Product> products;

    public ProductBasket() {
        products = new ArrayList<>();
    }
    /**
     * Метод addProduct() добавляет продукт в корзину
     * void ничего не возвращает
     */
    //
    public void addProduct(Product product) {
        products.add(product);
    }
    /**
     * Метод для получения общей стоимости корзины
     * Метод getTotalPrice() ничего не принимает и возвращает целое число — итоговую стоимость корзины.
     */
    public int getTotalPrice() {
        int total = 0;
        for (Product product : products) {
            if (product != null) {
                total += product.getPrice();
            }
        }
        return total;
    }
    /**
     * Метод, который печатает содержимое корзины
     * метод isEmpty() для проверки, пуст ли список.
     * метод printProductBasket() проверяет, пуст ли список продуктов.Если пуст, выводит "в корзине пусто"
     * Если есть продукты, выводит каждую строку с именем и стоимостью, а в конце — общую сумму "Итого".
     */
    public void printProductBasket() {
        int specialCount = 0;
        if (products.isEmpty()) {
            System.out.println("в корзине пусто");
            return;
        } else {
            for (Product product : products) {
                if (product != null) {
                    System.out.println(product);
                }
            }
            for (Product product : products) {
                if (product != null && product.isSpecial()) {
                    specialCount++;
                }
            }

            System.out.println("Итого: " + getTotalPrice());
            System.out.println("Специальных товаров: " + specialCount);
        }
    }
    /**
     * Метод проверки продукта в корзине по имени
     * products - список продуктов
     * @param name - имя продукта
     * @return - возвращает значение true (истины), если название проверяемого продукта совпадает, с тем, что есть в корзине, иначе false
     * equalsIgnoreCase - применяется для игнорирования регистра
     */
    public boolean hasProduct(String name) {
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }
    /**
     * Метод clear() - метод очистки корзины. Данный метод только очищает массив
     * Arrays.fill(products, null) - устанавливает значение null для всех элементов массива
     */
//    public void clear() {
//        Arrays.fill(products, null);
//    }
}
