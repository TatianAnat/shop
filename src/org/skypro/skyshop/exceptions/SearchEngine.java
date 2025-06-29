package org.skypro.skyshop.exceptions;

import java.util.List;

public class SearchEngine {
    public Searchable findBestMatch(String search, List<? extends Searchable> items) throws BestResultNotFound {
        if (search == null || search.isEmpty() || items == null || items.isEmpty()) {
            return null;
        }

        Searchable bestMatch = null;
        int maxCount = 0;

        for (Searchable item : items) {
            String term = item.getSearchTerm();
            int count = countOccurrences(term,search);
            if (count > maxCount) {
                maxCount = count;
                bestMatch = item;
            }
        }

        return bestMatch;
    }

    private int countOccurrences(String text, String sub) {
        if (text == null || sub == null || sub.isEmpty()) {
            return 0;
        }
        int count = 0;
        int index = 0;
        while ((index = text.indexOf(sub,index)) != -1) {
            count++;
            index += sub.length();
        }
        return count;
    }
}
