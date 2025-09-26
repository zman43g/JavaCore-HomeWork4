package org.skypro.skyshop.article;

import org.skypro.skyshop.exeptions.BestResultNotFound;

import java.util.ArrayList;
import java.util.List;

public class SearchEngine {
    private final List<Searchable> searchables;

    public SearchEngine() {
        this.searchables = new ArrayList<>();
    }


    public List<Searchable> search(String query) {
        List<Searchable> searchResults = new ArrayList<>();
        for (Searchable searchable : searchables) {
            if (searchable != null && searchable.searchTerm().contains(query)) {
                searchResults.add(searchable);
            }
        }
        if (!searchResults.isEmpty()) {
            for (Searchable searchResult : searchResults) {
                System.out.println("Результат поиска по запросу " + query + " :" + searchResult.getStringRepresentation());
            }
        } else {
            System.out.println("По запросу " + query + " ничего не найдено!");
        }
        return searchResults;
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

