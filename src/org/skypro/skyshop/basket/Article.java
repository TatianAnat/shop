package org.skypro.skyshop.basket;

import org.skypro.skyshop.exceptions.Searchable;
import org.skypro.skyshop.product.Product;

import java.util.Objects;

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
    public String getSearchTerm() {
        return title;
    }

    @Override
    public String getName() {
        return "";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return title != null ? title.equals(article.title) : article.title == null;
    }

    @Override
    public int hashCode() {
        return title != null ? title.hashCode() : 0;
    }
}
