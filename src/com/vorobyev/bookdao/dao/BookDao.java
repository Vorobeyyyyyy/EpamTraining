package com.vorobyev.bookdao.dao;

import com.vorobyev.bookdao.entity.Book;
import com.vorobyev.bookdao.entity.Genre;
import com.vorobyev.bookdao.exception.DaoException;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Predicate;

public interface BookDao {
    void add(Book book) throws DaoException;

    void removeById(long id) throws DaoException;

    void removeByIndex(int index) throws DaoException;

    void changeBookLabel(long id, String newLabel) throws DaoException;

    Optional<Book> findByIndex(int index);

    List<Book> findAll();

    List<Book> findBy(Predicate<Book> bookPredicate);

    Optional<Book> findById(long id);

    List<Book> findByLabel(String label);

    List<Book> findByGenre(Set<Genre> genres);

    List<Book> findByYear(int year);

    List<Book> findByAuthor(Set<String> authors);

    void clear();

    boolean exists(long id);
}
