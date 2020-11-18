package com.vorobyev.day4task1.service;

import com.vorobyev.day4task1.entity.Array;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Arrays;

import static org.testng.Assert.*;

public class SortServiceTest {
    private Array array;
    private Array sortedArray;
    private SortService sortService;

    @BeforeTest
    public void init(){
        int[] ints = {10, 2, 45, 11, -6, 27, 165, 44, 2334};
        array = new Array(ints);
        Arrays.sort(ints);
        sortedArray = new Array(ints);
        sortService = new SortService();
    }

    @Test
    public void testIsSorted() {
        boolean expected = sortService.isSorted(sortedArray);
        assertTrue(expected);
    }

    @Test
    public void testBubbleSort() {
        Array actual = sortService.bubbleSort(array);
        Array expected = sortedArray;
        assertEquals(actual, expected);
    }

    @Test
    public void testInsertionSort() {
        Array actual = sortService.insertionSort(array);
        Array expected = sortedArray;
        assertEquals(actual, expected);
    }

    @Test
    public void testSelectionSort() {
        Array actual = sortService.selectionSort(array);
        Array expected = sortedArray;
        assertEquals(actual, expected);
    }
}