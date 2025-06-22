package org.skypro.skyshop.articles;

import org.skypro.skyshop.search.Searchable;

public final class Article implements Searchable {

    private final String title;
    private final String text;

    public Article(String title, String text) {
        if (title == null || text == null) {
            throw new IllegalArgumentException("Название и текст статьи не могут быть пустыми");

        }
        this.title = title;
        this.text = text;
    }

    public String getTitle(){
        return title;
    }

    public String getText(){
        return text;
    }

    @Override
    public String getSearchTerm(){
        return this.toString();
    }

    @Override
    public String getContentType() {
        return "";
    }

    @Override
    public String getName(){
        return title;
    }

    @Override
    public String getStringRepresentation() {
        return getName() + " - " + getContentType();
    }

    @Override
    public String toString() {
        return title + "\n" + text;
    }
}
