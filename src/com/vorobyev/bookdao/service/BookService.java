package com.vorobyev.bookdao.service;

import com.vorobyev.bookdao.entity.Book;
import com.vorobyev.bookdao.exception.ServiceException;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public interface BookService {
    public void addToDao(Book book) throws ServiceException;

    public void removeFromDaoById(long id) throws ServiceException;

    public void removeFromDaoByIndex(int index) throws ServiceException;

    public void changeBookLabelInDao(long id, String newLabel) throws ServiceException;

    public List<Book> findAllInDao();

    public List<Book> findAllInDao(Comparator<Book> comparator);

    public Optional<Book> findByIndex(int index);

    public List<Book> findByYearInDao(int year, Comparator<Book> comparator);
}
