package org.skypro.skyshop.exceptions;

import java.util.*;
import java.util.stream.Collectors;

public class SearchEngine {
    /**
     * хранит все доступные для поиска объекты
     */
    private final List<Searchable> items = new ArrayList<>();
    /**
     * компаратор для сортировки Sarchable по имени
     */
    private  final SearchableComparator comparator = new SearchableComparator();
    /**
     * добавляет объект Searchable в список
     * @param item объект для добавления
     */
    public void addItem(Searchable item) {
        items.add(item);
    }

    /**
     * возвращает текущий список всех объектов.
     * список возвращается, чтоб сохранить порядок и возможность использования Stream API
     * @return список объектов Searchable
     */
    public List<Searchable> getItems() {
        return items;
    }

    /**
     * Поиск с использованием Stream API, без циклов
     * Возвращает отсортированный набор (TreeSet) с компаратором по имени
     * если запрос пустой, возвращаем пустой набор
     * @param query поисковая строка
     * @return отсортированное множество результатов
     */
    public Set<Searchable> search(String query)
    {
        if (query == null || query.isEmpty()) {
            return new TreeSet<>(comparator);
        }
        String queryLower = query.toLowerCase();

        return  items.stream()
                .filter(item -> item.getName() != null && item.getName().toLowerCase().contains(queryLower))
                .collect(Collectors.toCollection(() -> new TreeSet<>(comparator)));
    }
    /**
     * Метод findBestMatch принимает поисковую строку и список объектов Searchable.
     * Метод поиска лучшего совпадения - возвращает объект Searchable с максимальным количеством вхождений поискового запроса
     * @param search - поисковая строка
     * @param items - список объектов для поиска
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
     * метод подсчитывает количество неперекрывающихся вхождений подстроки (игнорируя регистр).
     * @param text основной текст
     * @param subLower -  искомая строка(уже переведа к нижнему регистру).
     * @return количество вхождений
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
     * вложенный класс компаратора для сортировки Searchable по имени
     */
    public static class SearchableComparator implements Comparator<Searchable> {
        @Override
        public int compare(Searchable o1, Searchable o2) {
            if (o1 == o2) return 0;
            if (o1 == null) return -1;
            if (o2 == null) return 1;
            if (o1.getName() == null && o2.getName() == null) return 0;
            if (o1.getName() == null) return -1;
            if (o2.getName() == null) return 1;
            return o1.getName().compareTo(o2.getName());
        }
    }

}
