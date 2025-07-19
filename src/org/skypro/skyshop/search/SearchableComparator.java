package org.skypro.skyshop.search;

import org.skypro.skyshop.basket.Article;

import java.util.Comparator;

public class SearchableComparator implements Comparator<Searchable> {
    @Override
    public int compare(Searchable a1, Searchable a2) {
        /**
         * сравниваем длины имен
         */
        if (a1 == a2) return 0;
        if (a1 == null) return -1;
        if (a1 == null) return 1;
//        int lenghtCompare = Integer.compare(a2.getName().length(),a1.getName().length());
//        if (lenghtCompare != 0) {
//            return  lenghtCompare;
//        }
        return  a1.getName().compareTo(a2.getName());
    }
}
