package com.thoughtworks.go.sample.models;

public class Book {

    private final long id = -1;

    private String isbn;
    private String name;
    private String author;
    private String publisher;

    Book() {
    }

    public Book(String isbn, String name, String author, String publisher) {
        this.isbn = isbn;
        this.name = name;
        this.author = author;
        this.publisher = publisher;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }
}
