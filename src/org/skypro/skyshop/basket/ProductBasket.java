package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;

public class ProductBasket {
    private Map<String, List<Product>> products;

    public ProductBasket() {
        products = new HashMap<>();
    }

    /**
     * Метод добавления продукта
     * computeIfAbsent проверяет наличие ключа и при его отсутствии создаёт новый список продуктов
     */
    public void addProduct(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("продукт не может быть нулевым");
        }
        products.computeIfAbsent(product.getName(), k -> new ArrayList<>()).add(product);
    }

    public void removeProduct(Product product) {
        String name = product.getName();
        List<Product> list = products.get(name);
        if (list.isEmpty()) {
            products.remove(name);
        }
    }

    /**
     * Метод для удаления всех продуктов с заданным наименованием
     *
     * @param name
     * @return
     */
    public List<Product> removeProductsByName(String name) {
        List<Product> removedProducts = products.remove(name);
        return removedProducts != null ? removedProducts : new ArrayList<>();

        }


    /**
     * Метод для получения общей стоимости корзины
     * Метод getTotalPrice() ничего не принимает и возвращает целое число — итоговую стоимость корзины.
     */
    public int getTotalPrice() {
        int total = 0;
        for (List<Product> productList : products.values()) {
            for (Product product : productList) {
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
        boolean isEmpty = true;
        int specialCount = 0;
        for (List<Product> productList : products.values()) {
            if (!productList.isEmpty()) {
                isEmpty = false;
                break;
            }
        }
        if (products.isEmpty() || isEmpty) {
            System.out.println("в корзине пусто");
        } else {
            for (List<Product> productList : products.values()){
                for (Product product : productList) {
                    if (product != null) {
                        System.out.println(product);
                    }
                }
            }
            for (List<Product> productList : products.values()){
                for (Product product : productList) {
                    if (product != null && product.isSpecial()) {
                        specialCount++;
                    }
                }
            }
            System.out.println("Итого: " + getTotalPrice());
            System.out.println("Специальных товаров: " + specialCount);
        }
    }

    /**
     * Метод проверки продукта в корзине по имени
     * products - список продуктов
     *
     * @param name - имя продукта
     * @return - возвращает значение true (истины), если название проверяемого продукта совпадает, с тем, что есть в корзине, иначе false
     * equalsIgnoreCase - применяется для игнорирования регистра
     */
    public boolean hasProduct(String name) {
        if (name == null || name.isBlank()) {
            return false;
        }
        for (List<Product> productList : products.values()) {
            for (Product product : productList) {
                if (product.getName().equalsIgnoreCase(name)) {
                    return true;
                }
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