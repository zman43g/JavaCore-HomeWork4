package org.skypro.skyshop.article;

import org.skypro.skyshop.exeptions.BestResultNotFound;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class SearchEngine {
    private final List<Searchable> searchables;

    public SearchEngine() {
        this.searchables = new ArrayList<>();
    }

    public Map<String, Searchable> search(String query) {
        if (query == null) {
            throw new IllegalArgumentException("Query can't be null");
        }
        Map<String, Searchable> searchResults = new TreeMap<>();
        if (query.isBlank()) {
            return searchResults;
        }
        for (Searchable searchable : searchables) {
            if (searchable.searchTerm().toLowerCase().contains(query.toLowerCase())) {
                searchResults.put(searchable.searchTerm(), searchable);
            }
        }

        return searchResults;
    }

    public void printSearchables(Map<String, Searchable> searchResults) {
        if (!searchResults.isEmpty()) {
            System.out.println("Результаты поиска по запросу: ");
            for (Searchable searchable : searchResults.values()) {
                System.out.println(searchable);
            }
        } else {
            System.out.println("Совпадения не найдены");
        }
    }

    public void add(Searchable newAdd) {
        searchables.add(newAdd);
    }

    public void printSearch() {
        for (Searchable searchable : searchables) {
            System.out.println(searchable.getStringRepresentation());
        }
    }


    public Searchable bestMatch(String search) throws BestResultNotFound {

        Searchable bestResults = null;
        int maxInstances = 0;

        for (Searchable searchable : searchables) {
            int numberOfInstances = 0;
            int index = 0;
            int searchIndex = searchable.searchTerm().indexOf(search, index);
            while (searchIndex != -1) {
                numberOfInstances++;
                index = searchIndex + search.length();
                searchIndex = searchable.searchTerm().indexOf(search, index);
                if (numberOfInstances > maxInstances) {
                    maxInstances = numberOfInstances;
                    bestResults = searchable;

                }
            }
        }
        if (bestResults == null) {
            throw new BestResultNotFound("По запросу " + search + " совпадения не найдены");
        } else
            return bestResults;
    }

}

