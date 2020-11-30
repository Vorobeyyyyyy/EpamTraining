package com.vorobyev.bookdao.service.impl;

import com.vorobyev.bookdao.comparator.BookComparator;
import com.vorobyev.bookdao.dao.BookDao;
import com.vorobyev.bookdao.dao.impl.BookDaoImpl;
import com.vorobyev.bookdao.entity.Book;
import com.vorobyev.bookdao.entity.Genre;
import com.vorobyev.bookdao.exception.DaoException;
import com.vorobyev.bookdao.exception.ServiceException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.testng.Assert.*;

public class BookServiceImplTest {
    private static final Logger logger = LogManager.getLogger();

    BookServiceImpl service = new BookServiceImpl();
    BookDao dao = BookDaoImpl.getInstance();
    List<Book> reference = new ArrayList<>();

    @BeforeMethod
    public void initDao() {
        dao.clear();
        reference.clear();
        reference.add(new Book("Alice in wonderland", Arrays.stream(new String[]{"Lewis Carroll"}).collect(Collectors.toSet()), 1876, EnumSet.noneOf(Genre.class)));
        reference.add(new Book("Through the Looking-Glass", Arrays.stream(new String[]{"Lewis Carroll"}).collect(Collectors.toSet()), 1869, EnumSet.noneOf(Genre.class)));
        reference.add(new Book("The Hunting of the Snark", Arrays.stream(new String[]{"Lewis Carroll"}).collect(Collectors.toSet()), 1876, EnumSet.noneOf(Genre.class)));
        reference.add(new Book("Sylvie and Bruno", Arrays.stream(new String[]{"Lewis Carroll"}).collect(Collectors.toSet()), 1881, EnumSet.noneOf(Genre.class)));
        try {
            for (Book book : reference) {
                dao.add(book);
            }
        } catch (DaoException exception) {
            logger.log(Level.ERROR, "Impossible exception {}", exception.getMessage());
        }

    }

    @Test
    public void testAddToDao() {
        Book newBook = new Book("Another book", Arrays.stream(new String[]{"Lewis Carroll"}).collect(Collectors.toSet()), 1876, EnumSet.noneOf(Genre.class));
        try {
            service.addToDao(newBook);
        } catch (ServiceException exception) {
            logger.log(Level.ERROR, "Impossible exception {}", exception.getMessage());
        }
        reference.add(newBook);
        List<Book> actual = service.findAllInDao();
        List<Book> expected = reference;
        assertEquals(actual, expected);
    }

    @Test
    public void testRemoveFromDao() {
        try {
            service.removeFromDaoByIndex(2);
        } catch (ServiceException exception) {
            logger.log(Level.ERROR, "Impossible exception {}", exception.getMessage());
        }
        reference.remove(2);
        List<Book> actual = service.findAllInDao();
        List<Book> expected = reference;
        assertEquals(actual, expected);
    }

    @Test
    public void testFindAllInDao() {
        List<Book> actual = service.findAllInDao();
        List<Book> expected = reference;
        assertEquals(actual, expected);
    }

    @Test
    public void testFindByYearInDao() {
        List<Book> actual = service.findByYearInDao(1876, BookComparator.LABEL);
        reference.remove(1);
        reference.remove(2);
        reference.sort(BookComparator.LABEL);
        List<Book> expected = reference;
        assertEquals(actual, expected);
    }
}