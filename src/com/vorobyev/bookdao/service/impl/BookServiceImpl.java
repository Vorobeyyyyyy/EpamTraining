package com.vorobyev.bookdao.service.impl;

import com.vorobyev.bookdao.dao.impl.BookDaoImpl;
import com.vorobyev.bookdao.entity.Book;
import com.vorobyev.bookdao.exception.DaoException;
import com.vorobyev.bookdao.exception.ServiceException;
import com.vorobyev.bookdao.service.BookService;
import com.vorobyev.bookdao.validator.BookValidator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class BookServiceImpl implements BookService {
    private static final Logger logger = LogManager.getLogger();

    private static final BookDaoImpl BOOK_DAO = BookDaoImpl.getInstance();

    @Override
    public void addToDao(Book book) throws ServiceException {
        if (book == null) {
            throw new ServiceException("Book was null");
        }
        if (BookValidator.isLabelValid(book.getBookLabel())) {
            throw new ServiceException("Invalid book label");
        }
        if (BookValidator.isPublishYearValid(book.getPublishYear())) {
            throw new ServiceException("Invalid publish year");
        }
        if (BookValidator.isAuthorNamesValid(book.getAuthors())) {
            throw new ServiceException("Invalid Authors");
        }
        try {
            BOOK_DAO.add(book);
            logger.log(Level.INFO, "Book ({}) has been added to Dao", book);
        } catch (DaoException exception) {
            throw new ServiceException(exception.getMessage());
        }
    }

    @Override
    public void removeFromDaoById(long id) throws ServiceException {
        try {
            BOOK_DAO.removeById(id);
        } catch (DaoException exception) {
            throw new ServiceException(exception);
        }
    }

    @Override
    public void removeFromDaoByIndex(int index) throws ServiceException {
        try {
            BOOK_DAO.removeByIndex(index);
        } catch (DaoException exception) {
            throw new ServiceException(exception);
        }
    }

    @Override
    public void changeBookLabelInDao(long id, String newLabel) throws ServiceException {
        if (newLabel == null) {
            throw new ServiceException("New label was null");
        }
        try {
            if (BookValidator.isLabelValid(newLabel)) {
                BOOK_DAO.changeBookLabel(id, newLabel);
            } else {
                throw new ServiceException("Invalid book label");
            }
        } catch (DaoException exception) {
            throw new ServiceException(exception.getMessage());
        }
    }

    @Override
    public List<Book> findAllInDao() {
        return BOOK_DAO.findAll();
    }

    @Override
    public List<Book> findAllInDao(Comparator<Book> comparator) {
        List<Book> result = BOOK_DAO.findAll();
        result.sort(comparator);
        return result;
    }

    @Override
    public Optional<Book> findByIndex(int index) {
        Optional<Book> result;
        result = BOOK_DAO.findByIndex(index);
        return result;
    }

    @Override
    public List<Book> findByYearInDao(int year, Comparator<Book> comparator) {
        List<Book> result = BOOK_DAO.findByYear(year);
        result.sort(comparator);
        return result;
    }
}
