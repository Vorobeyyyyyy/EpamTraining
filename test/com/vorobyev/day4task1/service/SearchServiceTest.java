package com.vorobyev.day4task1.service;

import com.vorobyev.day4task1.entity.Array;
import com.vorobyev.day4task1.exception.SearchServiceException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class SearchServiceTest {
    private Array array;
    private SearchService searchService;

    @BeforeTest
    public void init(){
        int[] ints = {10, 2, 45, 11, -6, 27, 5, 124, 247, 233, 8, 165, 44, 2334};
        array = new Array(ints);
        searchService = new SearchService();
    }


    @Test
    public void testBinarySearch() {
        int[] sortedArray = {1 ,3, 5, 7, 9, 11, 16, 19, 26};
        Array array = new Array(sortedArray);
        int actual = 0;
        try {
            actual = searchService.binarySearch(array, 3);
        }
        catch (SearchServiceException ignored){}
        int expected = 1;
        assertEquals(actual, expected);
    }

    @Test
    public void testFindMinValue() {
        int actual = 0;
        try {
            actual = searchService.findMinValue(array);
        }
        catch (SearchServiceException ignored){}
        int expected = -6;
        assertEquals(actual, expected);
    }

    @Test
    public void testFindMaxValue() {
        int actual = 0;
        try {
            actual = searchService.findMaxValue(array);
        }
        catch (SearchServiceException ignored){}
        int expected = 2334;
        assertEquals(actual, expected);
    }

    @Test
    public void testFindAll() {
        Array actual = searchService.findAll(array, a -> a < 0);
        int[] ints1 = {-6};
        Array expected = new Array(ints1);
        assertEquals(actual, expected);
    }

    @Test
    public void testFindAllSimple() {
        int[] simpleInts = {2, 11, 5, 233};
        Array expected = new Array(simpleInts);
        Array actual = searchService.findAllSimple(array);
        assertEquals(actual, expected);
    }

    @Test
    public void testFindAllFibonacci() {
        int[] fibonacciInts = {2, 5, 233, 8};
        Array expected = new Array(fibonacciInts);
        Array actual = searchService.findAllFibonacci(array);
        assertEquals(actual, expected);
    }

    @Test
    public void testFindAllUnique() {
        int[] fibonacciInts = {124, 247, 165};
        Array expected = new Array(fibonacciInts);
        Array actual = searchService.findAllThreeUnique(array);
        assertEquals(actual, expected);
    }
}