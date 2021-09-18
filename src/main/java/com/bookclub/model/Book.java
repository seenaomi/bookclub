package com.bookclub.model;

import java.util.List;

public class Book {

    private String isbn;
    private String title;
    private String description;
    private int numOfPages;
    private List<String> authors;

    public Book() {
    } //end of constructor that takes no params

    public Book(String isbn, String title, String description, int numOfPages, List<String> authors) {
        this.isbn = isbn;
        this.title = title;
        this.description = description;
        this.numOfPages = numOfPages;
        this.authors = authors;
    } //end of constructor that takes all params

    public String getIsbn() {
        return isbn;
    } //end of getIsbn

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    } //end of setIsbn

    public String getTitle() {
        return title;
    } //end of getTitle

    public void setTitle(String title) {
        this.title = title;
    } //end of setTitle

    public String getDescription() {
        return description;
    } //end of getDescription

    public void setDescription(String description) {
        this.description = description;
    } //end of setDescription

    public int getNumOfPages() {
        return numOfPages;
    } //end of getNumOfPages

    public void setNumOfPages(int numOfPages) {
        this.numOfPages = numOfPages;
    } //end of setNumOfPage

    public List<String> getAuthors() {
        return authors;
    } //end of getAuthors

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    } //end of setAuthors

    /*
    *
    * */
    public String toString(){
        return String.format("Book{isbn=%s, title=%s, description=%s, numOfPages=%s, authors=$s}", getIsbn(), getTitle(), getDescription(), getNumOfPages(), getAuthors());
    } //end of toString
}
