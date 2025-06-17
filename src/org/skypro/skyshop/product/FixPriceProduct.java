package org.skypro.skyshop.product;

public class FixPriceProduct extends Product{
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
}
