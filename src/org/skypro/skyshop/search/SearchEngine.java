package org.skypro.skyshop.search;

public class SearchEngine {
    private final Searchable[] items;
    private int count = 0;

    public SearchEngine(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Размер должен быть положительным!");
        }
        this.items = new Searchable[size];
    }

    public void add(Searchable item) {
        if (count >= items.length) {
            throw new IllegalStateException("заполнен");
        }
        items[count++] = item;
    }

    /**
     * Для строк, contains() проверяет, является ли заданная подстрока частью данной строки.
     *
     * @param query подстрока
     * @return может содержать null-элементы, если найдено меньше 5
     */
    public Searchable[] search(String query) {
        Searchable[] results = new Searchable[5];
        int found = 0;
        for (int i = 0; i < count; i++) {
            if (items[i] != null && items[i].getSearchTerm().contains(query)) {
                results[found++] = items[i];
                if (found == 5) break;
            }
        }
        return results;
    }
}
