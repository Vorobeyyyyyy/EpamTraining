package com.vorobyev.day4task2.service;

import java.util.Comparator;

public class JaggedArrayService {
    public void sort(int[][] array, Comparator<int[]> comparator, boolean up) {
        boolean sorted = false;
        while(!sorted) {
            sorted = true;
            for (int i = 0; i < array.length - 1; i++) {
                int compareResult = comparator.compare(array[i], array[i+1]);
                boolean needToSwap = compareResult != 0 && compareResult < 0 ^ up;
                if (needToSwap) {
                    int[] temp = array[i];
                    array[i] = array[i+1];
                    array[i+1] = temp;
                    sorted = false;
                }
            }
        }
    }
}