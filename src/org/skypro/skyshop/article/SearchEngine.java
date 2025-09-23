package org.skypro.skyshop.article;

import org.skypro.skyshop.product.Product;

import java.util.Arrays;

public class SearchEngine {
    private Searchable[] searchables;
    int count = 0;

    public SearchEngine(int size) {
        searchables = new Searchable[size];

    }

    public String[] search(String query) {
        String[] searchResults = new String[5];
        int counter = 0;
        for (int i = 0; i < searchables.length; i++) {
            if (searchables[i] != null && searchables[i].searchTerm().contains(query)) {
                searchResults[counter] = searchables[i].getStringRepresentation();
                counter++;
            }
            if (counter == 5) {
                break;
            }
        }

        return searchResults;
    }

    public void add(Searchable newAdd) {

        if (count == searchables.length) {
            return;
        }
        searchables[count] = newAdd;
        count++;
    }

}


