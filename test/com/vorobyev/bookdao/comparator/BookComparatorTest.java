package com.vorobyev.bookdao.comparator;

import com.vorobyev.bookdao.entity.Book;
import com.vorobyev.bookdao.entity.Genre;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.stream.Collectors;

import static org.testng.Assert.*;

public class BookComparatorTest {
    Book book1 = new Book("A book", Arrays.stream(new String[]{"Lewis Carroll", "Alex Vorobey"}).collect(Collectors.toSet()), 2020, Arrays.stream(new Genre[]{Genre.HISTORY, Genre.CRIME}).collect(Collectors.toCollection(() -> EnumSet.noneOf(Genre.class))));
    Book book2 = new Book("B book", Arrays.stream(new String[]{"Lewis Carroll"}).collect(Collectors.toSet()), 2010, Arrays.stream(new Genre[]{Genre.HISTORY, Genre.FAIRYTALE}).collect(Collectors.toCollection(() -> EnumSet.noneOf(Genre.class))));


    @Test
    public void genresTest(){
        int actual = BookComparator.GENRES.compare(book1, book2);
        assertTrue(actual < 0);
    }

    @Test
    public void authorsTest(){
        int actual = BookComparator.AUTHORS.compare(book1, book2);
        assertTrue(actual > 0);
    }

    @Test
    public void labelTest(){
        int actual = BookComparator.LABEL.compare(book1, book2);
        assertTrue(actual < 0);
    }

    @Test
    public void yearTest(){
        int actual = BookComparator.YEAR.compare(book1, book2);
        assertTrue(actual > 0);
    }
}