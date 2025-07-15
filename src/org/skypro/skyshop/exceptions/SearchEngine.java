package org.skypro.skyshop.exceptions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class SearchEngine {
    private List<Searchable> items;

    public SearchEngine() {
        items = new ArrayList<>();
    }

    public void addItem(Searchable item) {
        items.add(item);
    }

    public List<Searchable> getItems(){
        return items;
    }

    /**
     * Метод findBestMatch принимает поисковую строку и список объектов Searchable.
     * @return - возвращает наиболее подходящий объект Searchable
     * @throws BestResultNotFound - Метод выбрасывает проверяемое исключение собственного типа, если объект не найден
     */
    public Map<String, Searchable> search(String query) {
        Map<String, Searchable> resultMap = new TreeMap<>();
        for (Searchable item : items) {
            if (item.getName().toLowerCase().contains(query.toLowerCase())) {
                resultMap.put(item.getName(), item);
            }
        }
        return resultMap;
    }

    /**
     * метод подсчитывает количество неперекрывающихся вхождений подстроки.
     * @param text
     * @param subLower - преобразования строки в нижний регистр.
     * @return
     */
    private int countOccurrencesIgnoreCase(String text, String subLower) {
        if (text == null || subLower == null || subLower.isEmpty()) {
            return 0;
        }
        int count = 0;
        int index = 0;
        while ((index = text.indexOf(subLower,index)) != -1) {
            count++;
            index += subLower.length();
        }
        return count;
    }

    /**
     * Метод findBestMatch принимает поисковую строку и список объектов Searchable.
     * @param search - поисковая строка
     * @param items - список объектов Searchable
     * @return - возвращает наиболее подходящий объект Searchable
     * @throws BestResultNotFound - Метод выбрасывает проверяемое исключение собственного типа, если объект не найден
     */
    public Searchable findBestMatch(String search, List<? extends Searchable> items) throws BestResultNotFound {
        if (search == null || search.isEmpty() || items == null || items.isEmpty()) {
            throw new BestResultNotFound(search);
        }

        String searchLower = search.toLowerCase();
        Searchable bestMatch = null;
        int maxCount = 0;

        for (Searchable item : items) {
            String term = item.getSearchTerm();
            if (term == null) continue;
            int count = countOccurrencesIgnoreCase(term,searchLower);
            if (count > maxCount) {
                maxCount = count;
                bestMatch = item;
            }
        }

        if (bestMatch == null || maxCount == 0) {
            throw new BestResultNotFound(search);
        }

        return bestMatch;
    }

}
