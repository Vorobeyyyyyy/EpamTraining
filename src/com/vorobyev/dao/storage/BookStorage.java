package com.vorobyev.dao.storage;

import com.vorobyev.dao.entity.Book;

import java.util.HashSet;
import java.util.Set;

public class BookStorage {
    private static final BookStorage instance = new BookStorage();

    private final Set<Book> books;

    private BookStorage() {
        books = new HashSet<>();
    }

    public static BookStorage getInstance() {
        return instance;
    }

    public Set<Book> getBooks(){
        return books;
    }
}
