package com.vorobyev.day4task2.comparator;

import java.util.Comparator;

public class ComparatorBySum implements Comparator<int[]> {

    @Override
    public int compare(int[] array1, int[] array2) {
        int sum1 = 0;
        int sum2 = 0;
        for (int value : array1){
            sum1 += value;
        }
        for (int value : array2){
            sum2 += value;
        }
        return sum1 - sum2;
    }
}
