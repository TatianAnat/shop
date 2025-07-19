package org.skypro.skyshop.search;

import java.util.Objects;

public class MySearchable implements Searchable, Comparable<MySearchable> {
    private String name;

    public MySearchable(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    /**
     * реализация compareTo для сортировки по имени
     * @param o the object to be compared.
     * @return
     */
    @Override
    public int compareTo(MySearchable o) {
        if (o == null) return 1;
        return this.name.compareTo(o.name);
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof MySearchable that)) return false;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    @Override
    public String getSearchTerm() {
        return "";
    }
}
