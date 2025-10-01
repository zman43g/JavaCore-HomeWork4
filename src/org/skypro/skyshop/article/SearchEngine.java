package org.skypro.skyshop.article;

import org.skypro.skyshop.exeptions.BestResultNotFound;

import java.util.*;
import java.util.stream.Collectors;

public class SearchEngine {
    private final Set<Searchable> searchables;

    public SearchEngine() {
        this.searchables = new HashSet<>();
    }

    /*public Set<Searchable> search(String query) {
        if (query == null) {
            throw new IllegalArgumentException("Query can't be null");
        }
        Set<Searchable> searchResults = new TreeSet<>(new ReverseSearchableComparator());
        if (query.isBlank()) {
            return searchResults;
        }
        for (Searchable searchable : searchables) {
            if (searchable.searchTerm().toLowerCase().contains(query.toLowerCase())) {
                searchResults.add(searchable);
            }
        }
        if (searchResults.isEmpty()) {
            System.out.println("По запросу " + query + " совпадений не найдено");
            return searchResults;
        } else {
            return searchResults;
        }
    }*/

    public Set<Searchable> search(String query) {
        Set<Searchable> searchResult = searchables.stream()
                .filter(i -> i.searchTerm().toLowerCase().contains(query.toLowerCase()))
                .limit(5)
                .collect(Collectors.toCollection(() -> new TreeSet<>(new ReverseSearchableComparator())));
        if (searchResult.isEmpty()) {
            System.out.println("По запросу " + query + " ничего не найдено!");
        }

        return searchResult;
    }


    public static class ReverseSearchableComparator implements Comparator<Searchable> {
        public int compare(Searchable o1, Searchable o2) {
            if (o1.getNameOfSearchable().length() > o2.getNameOfSearchable().length()) {
                return -1;
            } else if (o1.getNameOfSearchable().length() < o2.getNameOfSearchable().length()) {
                return 1;
            } else {
                return o1.getNameOfSearchable().compareTo(o2.getNameOfSearchable());
            }
        }
    }


  /*  public void printSearchables(Set<Searchable> searchResults) {
        if (!searchResults.isEmpty()) {
            System.out.println("Результаты поиска по запросу: ");
            for (Searchable searchable : searchResults.values()) {
                System.out.println(searchable);
            }
        } else {
            System.out.println("Совпадения не найдены");
        }
    }*/

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

