package com.vorobyev.day4task2.comparator;

import java.util.Comparator;

public class ComparatorByMaxMin implements Comparator<int[]> {

    @Override
    public int compare(int[] array1, int[] array2) {
        int min1 = array1[0];
        int min2 = array2[0];
        for (int value : array1){
            if (value < min1){
                min1 = value;
            }
        }
        for (int value : array2){
            if (value < min2){
                min2 = value;
            }
        }
        return min1 - min2;
    }
}
