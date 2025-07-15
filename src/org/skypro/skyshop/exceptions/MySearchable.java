package org.skypro.skyshop.exceptions;

public class MySearchable implements Searchable {
    private String name;
    

    public MySearchable(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Searchable{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public String getName() {
        return "";
    }

    @Override
    public String getSearchTerm() {
        return "";
    }
}
