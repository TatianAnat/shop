package org.skypro.skyshop.exceptions;

import java.util.List;

public class SearchEngine {
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
}
