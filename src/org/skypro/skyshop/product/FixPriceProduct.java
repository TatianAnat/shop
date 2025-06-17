package org.skypro.skyshop.product;

public class FixPriceProduct extends Product {
    /**
     * Приватная константа FIXED_PRICE для фиксированной цены
     */
    private static final int FIXED_PRICE = 200;
    private String name;

    public FixPriceProduct(String name) {
        super(name);
        this.name = name;
    }

    /**
     * @return всегда возвращает одну и ту же цену для всех экземпляров класса
     */
    @Override
    public int getPrice() {
        return FIXED_PRICE;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    /**
     * переопределяем данный метод для каждого класса
     *
     * @return возвращает нужный вывод
     */
    @Override
    public String toString() {
        return getName() + ": Фиксированная цена " + FIXED_PRICE;
    }
}
