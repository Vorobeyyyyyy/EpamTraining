package com.vorobyev.day4task2.comparator;

import java.util.Comparator;

public class ComparatorByMaxMax implements Comparator<int[]> {
    @Override
    public int compare(int[] array1, int[] array2) {
        int max1 = array1[0];
        int max2 = array2[0];
        for (int value : array1){
            if (value > max1){
                max1 = value;
            }
        }
        for (int value : array2){
            if (value > max2){
                max2 = value;
            }
        }
        return max1 - max2;
    }
}
