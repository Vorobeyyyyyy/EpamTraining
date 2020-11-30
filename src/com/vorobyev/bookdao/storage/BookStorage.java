package com.vorobyev.bookdao.storage;

import com.vorobyev.bookdao.entity.Book;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;


public class BookStorage {
    private static final BookStorage instance = new BookStorage();

    private final List<Book> books;

    private BookStorage() {
        books = new ArrayList<>();
    }

    public static BookStorage getInstance() {
        return instance;
    }

    public List<Book> toList() {
        return new ArrayList<>(books);
    }

    public int size() {
        return books.size();
    }

    public boolean isEmpty() {
        return books.isEmpty();
    }

    public boolean contains(Object o) {
        return books.contains(o);
    }

    public Iterator<Book> iterator() {
        return books.iterator();
    }

    public Object[] toArray() {
        return books.toArray();
    }

    public <T> T[] toArray(T[] a) {
        return books.toArray(a);
    }

    public boolean add(Book book) {
        return books.add(book);
    }

    public boolean remove(Object o) {
        return books.remove(o);
    }

    public boolean containsAll(Collection<?> c) {
        return books.containsAll(c);
    }

    public boolean addAll(Collection<? extends Book> c) {
        return books.addAll(c);
    }

    public boolean addAll(int index, Collection<? extends Book> c) {
        return books.addAll(index, c);
    }

    public boolean removeAll(Collection<?> c) {
        return books.removeAll(c);
    }

    public boolean retainAll(Collection<?> c) {
        return books.retainAll(c);
    }

    public void replaceAll(UnaryOperator<Book> operator) {
        books.replaceAll(operator);
    }

    public void sort(Comparator<? super Book> c) {
        books.sort(c);
    }

    public void clear() {
        books.clear();
    }

    public Book get(int index) {
        return books.get(index);
    }

    public Book set(int index, Book element) {
        return books.set(index, element);
    }

    public void add(int index, Book element) {
        books.add(index, element);
    }

    public Book remove(int index) {
        return books.remove(index);
    }

    public int indexOf(Object o) {
        return books.indexOf(o);
    }

    public int lastIndexOf(Object o) {
        return books.lastIndexOf(o);
    }

    public ListIterator<Book> listIterator() {
        return books.listIterator();
    }

    public ListIterator<Book> listIterator(int index) {
        return books.listIterator(index);
    }

    public List<Book> subList(int fromIndex, int toIndex) {
        return books.subList(fromIndex, toIndex);
    }

    public Spliterator<Book> spliterator() {
        return books.spliterator();
    }

    public static <E> List<E> copyOf(Collection<? extends E> coll) {
        return List.copyOf(coll);
    }

    public <T> T[] toArray(IntFunction<T[]> generator) {
        return books.toArray(generator);
    }

    public boolean removeIf(Predicate<? super Book> filter) {
        return books.removeIf(filter);
    }

    public Stream<Book> stream() {
        return books.stream();
    }

    public Stream<Book> parallelStream() {
        return books.parallelStream();
    }

    public void forEach(Consumer<? super Book> action) {
        books.forEach(action);
    }
}
