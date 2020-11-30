package com.vorobyev.bookdao.dao.impl;

import com.vorobyev.bookdao.dao.BookDao;
import com.vorobyev.bookdao.entity.Book;
import com.vorobyev.bookdao.entity.Genre;
import com.vorobyev.bookdao.exception.DaoException;
import com.vorobyev.bookdao.storage.BookStorage;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BookDaoImpl implements BookDao {
    private static final BookDaoImpl instance = new BookDaoImpl();

    private final BookStorage books;

    private BookDaoImpl() {
        books = BookStorage.getInstance();
    }

    public static BookDaoImpl getInstance() {
        return instance;
    }

    @Override
    public Optional<Book> findByIndex(int index) {
        if (index < 0 || index > books.size()) {
            return Optional.empty();
        }
        return Optional.of(books.get(index));
    }

    @Override
    public void add(Book book) throws DaoException {
        if (books.contains(book)) {
            throw new DaoException("Book " + book + "already exist");
        }
        books.add(book);
    }

    @Override
    public void removeById(long id) throws DaoException {
        Optional<Book> book = findById(id);
        if (book.isEmpty()) {
            throw new DaoException("Book with such id not found");
        }
        books.remove(book.get());
    }

    @Override
    public void removeByIndex(int index) throws DaoException {
        if (index < 0 || index > books.size()) {
            throw new DaoException("Index out of bounds");
        }
        books.remove(index);
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
    public List<Book> findAll() {
        return books.toList();
    }

    @Override
    public List<Book> findBy(Predicate<Book> bookPredicate) {
        Stream<Book> bookStream = books.stream();
        bookStream = bookStream.filter(bookPredicate);
        return bookStream.collect(Collectors.toList());
    }

    @Override
    public Optional<Book> findById(long id) {
        Stream<Book> bookStream = books.stream();
        bookStream = bookStream.filter(book -> book.getBookId() == id);
        return bookStream.findFirst();
    }

    @Override
    public List<Book> findByLabel(String label) {
        return findBy(book -> book.getBookLabel().equals(label));
    }

    @Override
    public List<Book> findByGenre(Set<Genre> genres) {
        return findBy(book -> book.getGenres().containsAll(genres));
    }

    @Override
    public List<Book> findByYear(int year) {
        return findBy(book -> book.getPublishYear() == year);
    }

    @Override
    public List<Book> findByAuthor(Set<String> authors) {
        return findBy(book -> book.getGenres().containsAll(authors));
    }

    @Override
    public void clear() {
        books.clear();
    }

    @Override
    public boolean exists(long id) {
        return findById(id).isPresent();
    }
}
