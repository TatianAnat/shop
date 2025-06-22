package org.skypro.skyshop.articles;

public final class Article {

    private final String title;
    private final String text;

    public Article(String title, String text) {
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
    public String toString() {
        return title + "\n" + text;
    }
}
