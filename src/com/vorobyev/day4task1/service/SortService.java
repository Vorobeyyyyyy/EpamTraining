package com.vorobyev.day4task1.service;

import com.vorobyev.day4task1.entity.Array;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SortService {
    private static final Logger logger = LogManager.getLogger();

    public boolean isSorted(Array array) {

        int[] intArray = array.getArray();
        int i = 0;
        boolean sorted = true;
        while (i < intArray.length - 1) {
            if (intArray[i] > intArray[i + 1]) {
                sorted = false;
                break;
            }
            i++;
        }
        logger.info("sorted: {}", sorted);
        return sorted;
    }

    public Array bubbleSort(Array array) {
        int[] intArray = array.getArray();
        boolean sorted = false;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < intArray.length - 1; i++) {
                if (intArray[i] > intArray[i + 1]) {
                    int temp = intArray[i];
                    intArray[i] = intArray[i + 1];
                    intArray[i + 1] = temp;
                    sorted = false;
                }
            }
        }
        logger.info("Successful sort");
        return new Array(intArray);
    }

    public Array insertionSort(Array array) {
        int[] intArray = array.getArray();
        for (int i = 1; i < intArray.length; i++) {
            int current = intArray[i];
            int j = i - 1;
            while (j >= 0 && current < intArray[j]) {
                intArray[j + 1] = intArray[j];
                j--;
            }
            intArray[j + 1] = current;
        }
        logger.info("Successful sort");
        return new Array(intArray);
    }

    public Array selectionSort(Array array) {
        int[] intArray = array.getArray();
        for (int i = 0; i < intArray.length; i++) {
            int min = intArray[i];
            int minId = i;
            for (int j = i + 1; j < intArray.length; j++) {
                if (intArray[j] < min) {
                    min = intArray[j];
                    minId = j;
                }
            }
            int temp = intArray[i];
            intArray[i] = min;
            intArray[minId] = temp;
        }
        logger.info("Successful sort");
        return new Array(intArray);
    }
}
