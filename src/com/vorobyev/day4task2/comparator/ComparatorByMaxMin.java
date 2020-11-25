package com.vorobyev.day4task2.comparator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Comparator;

public class ComparatorByMaxMin implements Comparator<int[]> {
    private static final Logger logger = LogManager.getLogger();

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
        logger.debug("min1: {} min2: {}", min1, min2);
        return min1 - min2;
    }
}
