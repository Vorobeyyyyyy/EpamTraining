package com.vorobyev.day4task2.report;

import java.util.Arrays;

public class JaggedReport {
    public void sortedBySum(int[][] array){
        System.out.println("Sorted by sum of all elements: " + Arrays.deepToString(array));
    }
    public void sortedByMaxMax(int[][] array){
        System.out.println("Sorted by max element of all elements: " + Arrays.deepToString(array));

    }
    public void sortedByMaxMin(int[][] array){
        System.out.println("Sorted by min element of all elements: " + Arrays.deepToString(array));

    }
}
