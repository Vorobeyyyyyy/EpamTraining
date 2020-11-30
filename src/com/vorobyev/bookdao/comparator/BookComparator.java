package com.vorobyev.bookdao.comparator;

import com.vorobyev.bookdao.entity.Book;
import com.vorobyev.bookdao.entity.Genre;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public enum BookComparator implements Comparator<Book> {
    GENRES((o1, o2) -> {
        if (o1.getGenres().equals(o2.getGenres())) {
            return 0;
        }
        List<Genre> genres1 = new ArrayList<>(o1.getGenres());
        List<Genre> genres2 = new ArrayList<>(o2.getGenres());
        genres1.removeAll(o2.getGenres());
        genres2.removeAll(o1.getGenres());
        if (genres1.isEmpty()) {
            return -1;
        }
        if (genres2.isEmpty()) {
            return 1;
        }
        return genres1.get(0).compareTo(genres2.get(0));
    }),
    AUTHORS((o1, o2) -> {
        if (o1.getAuthors().equals(o2.getAuthors())) {
            return 0;
        }
        List<String> names1 = new ArrayList<>(o1.getAuthors());
        List<String> names2 = new ArrayList<>(o2.getAuthors());
        names1.removeAll(o2.getAuthors());
        names2.removeAll(o1.getAuthors());
        if (names1.isEmpty()) {
            return -1;
        }
        if (names2.isEmpty()) {
            return 1;
        }
        names1.sort(String::compareTo);
        names2.sort(String::compareTo);
        return names1.get(0).compareTo(names2.get(0));
    }),
    LABEL(Comparator.comparing(Book::getBookLabel)),
    YEAR(Comparator.comparing(Book::getPublishYear));

    private final Comparator<Book> comparator;

    BookComparator(Comparator<Book> comparator) {
        this.comparator = comparator;
    }

    @Override
    public int compare(Book o1, Book o2) {
        return comparator.compare(o1, o2);
    }
}
