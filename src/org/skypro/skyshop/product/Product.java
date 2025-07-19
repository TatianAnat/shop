package org.skypro.skyshop.product;

import org.skypro.skyshop.search.Searchable;

public abstract class Product implements Searchable {
    private String name;

        this.name = name;
    }

    public Product(String name) {
    }

    public String getName() {
        return name;
    }

    public abstract int getPrice();


    public boolean isSpecial() {
        return false;
    }

    @Override
    public String getSearchTerm() {
        return name;
    }

    public boolean isSpecial() {
        return false;
    }

    @Override
    public String getContentType() {
        return "PRODUCT";
    }


}

