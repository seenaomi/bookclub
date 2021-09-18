package com.bookclub.service.impl;

import com.bookclub.model.Book;
import com.bookclub.service.dao.BookDao;

import java.util.List;

public class MemBookDao implements BookDao {

    private List<Book> books;

    public MemBookDao() {

    }

    @Override
    public List<Book> list() {
        return this.books;
    }

    @Override
    public Book find(String key) {
        return null;
    }
}
