package com.vorobyev.dao.dao;

import com.vorobyev.dao.entity.Book;
import com.vorobyev.dao.entity.Genre;
import com.vorobyev.dao.exception.DaoException;

import java.util.Optional;
import java.util.Set;
import java.util.function.Predicate;

public interface BookDao {
    void add(Book book) throws DaoException;

    void remove(long id) throws DaoException;

    void changeBookLabel(long id, String newLabel) throws DaoException;

    Set<Book> findBy(Predicate<Book> bookPredicate);

    Optional<Book> findById(long id);

    Set<Book> findByLabel(String label);

    Set<Book> findByGenre(Set<Genre> genres);

    Set<Book> findByYear(int year);

    Set<Book> findByAuthor(Set<String> authors);

    boolean exists(long id);
}
