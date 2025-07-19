package org.skypro.skyshop.exceptions;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SearchEngine {
    private Set<Searchable> items = new HashSet<>();

    public void addItem(Searchable item) {
        items.add(item);
    }

    /**
     * Метод findBestMatch принимает Set.
     * @param search - поисковая строка
     * @param items - список объектов Searchable
     * @return - возвращает наиболее подходящий объект Searchable
     * @throws BestResultNotFound - Метод выбрасывает проверяемое исключение собственного типа, если объект не найден
     */
    public Searchable findBestMatch(String search, Set<? extends Searchable> items) throws BestResultNotFound {
        if (search == null || search.isEmpty() || items == null || items.isEmpty()) {
            throw new BestResultNotFound(search);
        }

        String searchLower = search.toLowerCase();
        Searchable bestMatch = null;
        int maxCount = 0;

        for (Searchable item : items) {
            String term = item.getSearchTerm();
            if (term == null) continue;
            int count = countOccurrencesIgnoreCase(term.toLowerCase(),searchLower);
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

    /**
     * метод подсчитывает количество неперекрывающихся вхождений подстроки.
     * @param text
     * @param subLower -  преобразования строки в нижний регистр.
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
     * метод возвращает отсортированный набор с результатами поиска
     * @param query
     * @return
     */
    public Set<Searchable> search(String query) {
        TreeSet<Searchable> found = new TreeSet<>();
        String queryLower = query.toLowerCase();

        for (Searchable item : items) {
            if (item.getName().toLowerCase().contains(queryLower)) {
                found.add(item);
            }
        }
        return found;
    }
    public Set<Searchable> getItems() {
        return items;
    }

}
