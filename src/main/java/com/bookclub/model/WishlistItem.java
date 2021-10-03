package com.bookclub.model;

/*
Lomax, R. (2021). CIS 530 Server-Side Development. Bellevue University.
Modified by N.See 2021
*/


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;

public class WishlistItem {

    @NotNull
    @NotEmpty(message = "ISBN is a required field")
    private String isbn;

    @NotNull
    @NotEmpty(message = "Title is a required field")
    private String title;

    @Id
    private String id;

    public WishlistItem() {
    }

    public WishlistItem(String isbn, String title, String id) {
        this.isbn = isbn;
        this.title = title;
        this.id = id;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String toString(){
        return String.format("WishlistItem{isbn=%s, title=%s, id=%s}", getIsbn(), getTitle(), getId());
    }
}
