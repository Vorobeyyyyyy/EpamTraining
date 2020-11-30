package com.vorobyev.bookdao.main;

import com.vorobyev.bookdao.comparator.BookComparator;
import com.vorobyev.bookdao.entity.Book;
import com.vorobyev.bookdao.entity.Genre;

import java.util.*;
import java.util.stream.Collectors;

public class ProjectMain {
    public static void main(String[] args) {
        Book book1 = new Book();
        Book book2 = new Book();
        book1.getGenres().add(Genre.EDUCATIONAL);
        System.out.println(BookComparator.AUTHORS.thenComparing(BookComparator.YEAR).compare(book1, book2));

    }
}
