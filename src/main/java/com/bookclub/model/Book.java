package com.bookclub.model;

/*
Lomax, R. (2021). CIS 530 Server-Side Development. Bellevue University.
Modified by N.See 2021
*/

import java.util.List;

public class Book {

    private String isbn;
    private String title;
    private String description;
    private String infoUrl;
    private int numOfPages;

    public Book() {
    }

    public Book(String isbn, String title, String description, String infoUrl, int numOfPages) {
        this.isbn = isbn;
        this.title = title;
        this.description = description;
        this.infoUrl = infoUrl;
        this.numOfPages = numOfPages;
    }

    public Book(String isbn, String title, String infoUrl) {
        this.isbn = isbn;
        this.title = title;
        this.infoUrl = infoUrl;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getInfoUrl() { return infoUrl; }

    public void setInfoUrl(String infoUrl) { this.infoUrl = infoUrl; }

    public int getNumOfPages() {
        return numOfPages;
    }

    public void setNumOfPages(int numOfPages) {
        this.numOfPages = numOfPages;
    }

    public String toString(){
        return String.format("Book{isbn=<isbn>, title=<title>, description=<description>, infoUrl=<infoUrl>, numOfPages=<numOfPages>}", getIsbn(), getTitle(), getDescription(), getInfoUrl(), getNumOfPages());
    }
}
