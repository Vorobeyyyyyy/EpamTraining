package com.vorobyev.day4task2.service;

import com.vorobyev.day4task2.comparator.ComparatorByMaxMax;
import com.vorobyev.day4task2.comparator.ComparatorByMaxMin;
import com.vorobyev.day4task2.comparator.ComparatorBySum;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Arrays;

import static org.testng.Assert.*;

public class JaggedArrayServiceTest {
    JaggedArrayService service = new JaggedArrayService();
    int[][] initArray = {{1, 27, 15, 22}, {15, 28, 3, 17, 11, 9}, {13, 25, 29, 8, 9}, {26, 5, 24}, {22, 10, 13, 21, 30}};
    int[][] array;


    @BeforeMethod
    public void beforeMethod(){
        array = initArray.clone();
    }

    @Test
    public void testSortByMaxMax() {
        ComparatorByMaxMax comparator = new ComparatorByMaxMax();
        service.sort(array, comparator , true);
        int[][] expected = {{26, 5, 24}, {1, 27, 15, 22}, {15, 28, 3, 17, 11, 9}, {13, 25, 29, 8, 9}, {22, 10, 13, 21, 30}};
        int[][] actual = array;
        assertEquals(actual, expected);
    }

    @Test
    public void testSortByMaxMin() {
        ComparatorByMaxMin comparator = new ComparatorByMaxMin();
        service.sort(array, comparator , false);
        int[][] expected = {{22, 10, 13, 21, 30}, {13, 25, 29, 8, 9}, {26, 5, 24}, {15, 28, 3, 17, 11, 9}, {1, 27, 15, 22}};
        int[][] actual = array;
        assertEquals(actual, expected);
    }

    @Test
    public void testSortBySum() {
        ComparatorBySum comparator = new ComparatorBySum();
        service.sort(array, comparator , true);
        int[][] expected = {{26, 5, 24}, {1, 27, 15, 22}, {15, 28, 3, 17, 11, 9}, {13, 25, 29, 8, 9}, {22, 10, 13, 21, 30}};
        int[][] actual = array;
        System.out.println(Arrays.deepToString(actual));
        assertEquals(actual, expected);
    }
}