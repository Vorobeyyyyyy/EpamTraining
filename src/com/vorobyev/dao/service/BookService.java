package com.vorobyev.dao.service;

import com.vorobyev.dao.dao.impl.BookDaoImpl;
import com.vorobyev.dao.entity.Book;
import com.vorobyev.dao.exception.DaoException;
import com.vorobyev.dao.exception.ServiceException;
import com.vorobyev.dao.validator.BookValidator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BookService {
    private static final Logger logger = LogManager.getLogger();

    private static final BookDaoImpl bookDao = BookDaoImpl.getInstance();

    public void addToDao(Book book) throws ServiceException {
        if (book == null) {
            throw new ServiceException("Book was null");
        }

        try {
            if (BookValidator.isLabelValid(book.getBookLabel())) {
                if (BookValidator.isPublishYearValid(book.getPublishYear())) {
                    if (BookValidator.isAuthorNamesValid(book.getAuthors())) {
                        bookDao.add(book);
                        logger.log(Level.INFO, "Book ({}) has been added to Dao", book);
                    } else {
                        throw new ServiceException("Invalid Authors");
                    }
                } else {
                    throw new ServiceException("Invalid publish year");
                }
            } else {
                throw new ServiceException("Invalid book label");
            }
        } catch (DaoException exception) {
            throw new ServiceException(exception.getMessage());
        }
    }

    public void removeFromDao(long id) throws ServiceException {
        try {
            bookDao.remove(id);
        } catch (DaoException exception) {
            throw new ServiceException(exception.getMessage());
        }
    }

    public void changeBookLabelInDao(long id, String newLabel) throws ServiceException {
        if (newLabel == null) {
            throw new ServiceException("New label was null");
        }
        try {
            if (BookValidator.isLabelValid(newLabel)) {
                bookDao.changeBookLabel(id, newLabel);
            } else {
                throw new ServiceException("Invalid book label");
            }
        } catch (DaoException exception) {
            throw new ServiceException(exception.getMessage());
        }
    }


}
