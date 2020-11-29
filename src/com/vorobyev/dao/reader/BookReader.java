package com.vorobyev.dao.reader;

import com.vorobyev.dao.dao.BookDao;
import com.vorobyev.dao.dao.impl.BookDaoImpl;
import com.vorobyev.dao.entity.Book;
import com.vorobyev.dao.entity.Genre;
import com.vorobyev.dao.exception.DaoException;
import com.vorobyev.day4task1.exception.ArrayScannerException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class BookReader {
    private static final Logger logger = LogManager.getLogger();

    BookDao bookDao = BookDaoImpl.getInstance();

    private static final int FIELD_COUNT = 4;
    private static final String FIELD_SPLITTER = "\\|";
    private static final String ARRAY_SPLITTER = "#";
    private static final int NAME_FIELD_NUMBER = 0;
    private static final int YEAR_FIELD_NUMBER = 1;
    private static final int GENRE_FIELD_NUMBER = 2;
    private static final int AUTHOR_FIELD_NUMBER = 2;

    public void fromFile(String path) {
        File file = new File(path);
        Scanner scanner;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException exception) {
            logger.error(exception.getMessage());
            return;
        }

        try {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                Book book = parseBook(line);
                bookDao.add(book);
            }
        } catch (IllegalStateException | NoSuchElementException | IllegalArgumentException | DaoException exception) {
            logger.log(Level.ERROR, exception.getMessage());
        } finally {
            scanner.close();
        }
    }

    public Book parseBook(String value) {
        String[] fields = value.split(FIELD_SPLITTER);
        if (fields.length != FIELD_COUNT) {
            throw new IllegalArgumentException("Wrong book format");
        }
        String name = fields[NAME_FIELD_NUMBER];
        int year = Integer.parseInt(fields[YEAR_FIELD_NUMBER]);
        String[] genresStringArray = fields[GENRE_FIELD_NUMBER].split(ARRAY_SPLITTER);
        EnumSet<Genre> genres = EnumSet.noneOf(Genre.class);
        for (String genreString : genresStringArray) {
            genres.add(Genre.valueOf(genreString));
        }
        String[] authorsArray = fields[AUTHOR_FIELD_NUMBER].split(ARRAY_SPLITTER);
        List<String> authorsList = Arrays.asList(authorsArray);
        Set<String> authors = new HashSet<>(authorsList);
        return new Book(name, authors, year, genres);
    }
}
