package com.vorobyev.bookdao.entity;

import com.vorobyev.bookdao.util.IdGenerator;

import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

public class Book {
    private final long bookId;
    private String bookLabel;
    private Set<String> authors;
    private int publishYear;
    private EnumSet<Genre> genres;

    public Book() {
        this.bookId = IdGenerator.getInstance().getNewId();
        this.bookLabel = "";
        this.authors = new HashSet<>();
        this.publishYear = 2000;
        this.genres = EnumSet.noneOf(Genre.class);
    }

    public Book(String bookLabel, Set<String> authors, int publishYear, EnumSet<Genre> genres) {
        this();
        this.bookLabel = bookLabel;
        this.authors.addAll(authors);
        this.publishYear = publishYear;
        this.genres.addAll(genres);
    }

    public long getBookId() {
        return bookId;
    }

    public String getBookLabel() {
        return bookLabel;
    }

    public void setBookLabel(String bookLabel) {
        this.bookLabel = bookLabel;
    }

    public Set<String> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<String> authors) {
        this.authors = authors;
    }

    public int getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(int publishYear) {
        this.publishYear = publishYear;
    }

    public EnumSet<Genre> getGenres() {
        return genres;
    }

    public void setGenres(EnumSet<Genre> genres) {
        this.genres = genres;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (bookId != book.bookId) return false;
        if (publishYear != book.publishYear) return false;
        if (bookLabel != null ? !bookLabel.equals(book.bookLabel) : book.bookLabel != null) return false;
        if (authors != null ? !authors.equals(book.authors) : book.authors != null) return false;
        return genres != null ? genres.equals(book.genres) : book.genres == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (bookId ^ (bookId >>> 32));
        result = 31 * result + (bookLabel != null ? bookLabel.hashCode() : 0);
        result = 31 * result + (authors != null ? authors.hashCode() : 0);
        result = 31 * result + publishYear;
        result = 31 * result + (genres != null ? genres.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Book{");
        sb.append("bookId=").append(bookId);
        sb.append(", bookLabel='").append(bookLabel).append('\'');
        sb.append(", authors=").append(authors);
        sb.append(", publishYear=").append(publishYear);
        sb.append(", genres=").append(genres);
        sb.append('}');
        return sb.toString();
    }
}
