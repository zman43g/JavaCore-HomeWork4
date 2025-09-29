package org.skypro.skyshop.article;

public final class Article implements Searchable {
    private final String articleName;
    private final String articleText;

    public Article(String articleName, String articleText) {
        this.articleName = articleName;
        this.articleText = articleText;
    }

    public String getArticleText() {
        return articleText;
    }

    @Override
    public String toString() {
        return articleName + " \n" + articleText;
    }

    @Override
    public String contentFound() {
        return articleText.getClass().getSimpleName();
    }

    @Override
    public String searchTerm() {
        return this + " ARTICLE";
    }
        @Override
    public String getStringRepresentation() {
        return " Имя " + articleText + " Тип Searchable объекта ARTICLE";

    }
}
