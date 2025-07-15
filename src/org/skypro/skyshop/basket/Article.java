package org.skypro.skyshop.basket;

import org.skypro.skyshop.exceptions.Searchable;

public class Article implements Searchable {
    private String title;

    public Article(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Название:  " + title;
    }

    @Override
    public String getName() {
        return "";
    }

    @Override
    public String getSearchTerm() {
        return title;
    }
}
