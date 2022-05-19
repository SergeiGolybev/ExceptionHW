package ru.netology.domain;

public class Book extends Product {

    protected String author;

    public Book(int id, String title, int value, String author) {

        super(id, title, value);
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}

