package org.skypro.skyshop.exceptions;

public class BestResultNotFound extends Exception {
    public BestResultNotFound(String searchQuery) {
        super("Для поискового запроса " + searchQuery + " не найден подходящий объект.");
    }
}
