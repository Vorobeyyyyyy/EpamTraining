package com.vorobyev.dao.dao.impl;

import com.vorobyev.dao.dao.BookDao;
import com.vorobyev.dao.entity.Book;
import com.vorobyev.dao.entity.Genre;
import com.vorobyev.dao.exception.DaoException;
import com.vorobyev.dao.storage.BookStorage;

import java.util.Optional;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BookDaoImpl implements BookDao {
    private static final BookDaoImpl instance = new BookDaoImpl();

    private final Set<Book> books;

    private BookDaoImpl(){
        books = BookStorage.getInstance().getBooks();
    }

    public static BookDaoImpl getInstance() {
        return instance;
    }

    @Override
    public void add(Book book) throws DaoException {
        if (books.contains(book)) {
            throw new DaoException("Book " + book + "already exist");
        }
        books.add(book);
    }

    @Override
    public void remove(long id) throws DaoException {
        Optional<Book> book = findById(id);
        if (book.isEmpty()) {
            throw new DaoException("Book with such id not found");
        }
        books.remove(book.get());
    }

    @Override
    public void changeBookLabel(long id, String newLabel) throws DaoException {
        Optional<Book> optionalBook = findById(id);
        if (optionalBook.isEmpty()) {
            throw new DaoException("Book with such id not found");
        }
        Book book = optionalBook.get();
        book.setBookLabel(newLabel);
    }

    @Override
    public Set<Book> findBy(Predicate<Book> bookPredicate) {
        Stream<Book> bookStream = books.stream();
        bookStream = bookStream.filter(bookPredicate);
        return bookStream.collect(Collectors.toSet());
    }

    @Override
    public Optional<Book> findById(long id) {
        Stream<Book> bookStream = books.stream();
        bookStream = bookStream.filter(book -> book.getBookId() == id);
        return bookStream.findFirst();
    }

    @Override
    public Set<Book> findByLabel(String label) {
        return findBy(book -> book.getBookLabel().equals(label));
    }

    @Override
    public Set<Book> findByGenre(Set<Genre> genres) {
        return findBy(book -> book.getGenres().containsAll(genres));
    }

    @Override
    public Set<Book> findByYear(int year) {
        return findBy(book -> book.getPublishYear() == year);
    }

    @Override
    public Set<Book> findByAuthor(Set<String> authors) {
        return findBy(book -> book.getGenres().containsAll(authors));
    }

    @Override
    public boolean exists(long id) {
        return findById(id).isPresent();
    }
}
