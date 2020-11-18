package com.vorobyev.day4task1.service;

import com.vorobyev.day4task1.entity.Array;

public class SortService {

    public boolean isSorted(Array array){
        int[] intArray = array.getArray();
        int i = 0;
        boolean sorted = true;
        while(i < intArray.length - 1){
            if (intArray[i] > intArray[i + 1]){
                sorted = false;
                break;
            }
            i++;
        }
        return sorted;
    }

    public Array bubbleSort(Array array) {
        int[] intArray = array.getArray();
        boolean sorted = false;
        while(!sorted) {
            sorted = true;
            for (int i = 0; i < intArray.length - 1; i++) {
                if (intArray[i] > intArray[i+1]) {
                    int temp = intArray[i];
                    intArray[i] = intArray[i+1];
                    intArray[i+1] = temp;
                    sorted = false;
                }
            }
        }
        return new Array(intArray);
    }

    public Array insertionSort(Array array) {
        int[] intArray = array.getArray();
        for (int i = 1; i < intArray.length; i++) {
            int current = intArray[i];
            int j = i - 1;
            while(j >= 0 && current < intArray[j]) {
                intArray[j+1] = intArray[j];
                j--;
            }
            intArray[j+1] = current;
        }
        return new Array(intArray);
    }

    public Array selectionSort(Array array) {
        int[] intArray = array.getArray();
        for (int i = 0; i < intArray.length; i++) {
            int min = intArray[i];
            int minId = i;
            for (int j = i+1; j < intArray.length; j++) {
                if (intArray[j] < min) {
                    min = intArray[j];
                    minId = j;
                }
            }
            int temp = intArray[i];
            intArray[i] = min;
            intArray[minId] = temp;
        }
        return new Array(intArray);
    }
}
