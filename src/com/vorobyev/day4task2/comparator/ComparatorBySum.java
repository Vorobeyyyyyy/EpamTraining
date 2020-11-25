package com.vorobyev.day4task2.comparator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Comparator;

public class ComparatorBySum implements Comparator<int[]> {
    private static final Logger logger = LogManager.getLogger();

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
        logger.debug("Sum1: {} Sum2: {}", sum1, sum2);
        return sum1 - sum2;
    }
}
