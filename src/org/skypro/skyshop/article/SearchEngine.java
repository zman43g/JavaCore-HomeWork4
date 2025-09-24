package org.skypro.skyshop.article;

import org.skypro.skyshop.exeptions.BestResultNotFound;

public class SearchEngine {
    private Searchable[] searchables;
    int count = 0;

    public SearchEngine(int size) {
        searchables = new Searchable[size];

    }

    public String[] search(String query) {
        String[] searchResults = new String[5];
        int counter = 0;
        for (Searchable searchable : searchables) {
            if (searchable != null && searchable.searchTerm().contains(query)) {
                searchResults[counter] = searchable.getStringRepresentation();
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

    public Searchable bestMatch(String search) throws NullPointerException {

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



    /*str = "helloabcdehellonnnnnnhello"
    substring = "hello"
    quantity = 0
    index = 0
    индексПодстроки = str.indexOf(substring, индекс)

            while(индексПодстроки != -1){
        количество++;
        индекс = индексПодстроки + substring.length();
        индексПодстроки = str.indexOf(substring, индекс)
        }*/

}

