package com.vorobyev.day4task2.comparator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Comparator;

public class ComparatorByMaxMax implements Comparator<int[]> {
    private static final Logger logger = LogManager.getLogger();

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
        logger.debug("max1: {} max2: {}", max1, max2);
        return max1 - max2;
    }
}
