package com.vorobyev.day4task1.service;

import com.vorobyev.day4task1.entity.Array;
import com.vorobyev.day4task1.exception.SearchServiceException;

import java.util.function.IntPredicate;

public class SearchService {

    public int binarySearch(Array array, int value) throws SearchServiceException {
        SortService sortService = new SortService();
        if(!sortService.isSorted(array)){
            throw new SearchServiceException("Array is not sorted!");
        }

        int[] intArray = array.getArray();
        int start = 0;
        int end = intArray.length - 1;
        int pos = (start + end) / 2;
        while (end != start){
            if (value < intArray[pos]){
                end = pos - 1;
            }
            if (value > intArray[pos]){
                start = pos + 1;
            }
            if (value == intArray[pos]){
                break;
            }
            pos = (start + end) / 2;
        }

        if (intArray[pos] != value){
            throw new SearchServiceException("No such element");
        }
        return pos;
    }

    public int findMinValue(Array array) throws SearchServiceException {
        if (array.size() == 0){
            throw new SearchServiceException("Array is empty");
        }
        int[] intArray = array.getArray();
        int min = intArray[0];
        for (int i = 1; i < intArray.length; i++){
            if (intArray[i] < min){
                min = intArray[i];
            }
        }
        return min;
    }

    public int findMaxValue(Array array) throws SearchServiceException {
        if (array.size() == 0){
            throw new SearchServiceException("Array is empty");
        }
        int[] intArray = array.getArray();
        int max = intArray[0];
        for (int i = 1; i < intArray.length; i++){
            if (intArray[i] > max){
                max = intArray[i];
            }
        }
        return max;
    }

    public Array findAll(Array array, IntPredicate intPredicate){
        Array simpleArray = new Array();
        for(int a : array.getArray()){
            if (intPredicate.test(a)){
                simpleArray.add(a);
            }
        }
        return simpleArray;
    }

    public Array findAllSimple(Array array){
        IntService intService = new IntService();
        return findAll(array, intService::isSimple);
    }

    public Array findAllFibonacci(Array array){
        IntService intService = new IntService();
        return findAll(array, intService::isFibonacci);
    }

    public Array findAllThreeUnique(Array array){
        IntService intService = new IntService();
        return findAll(array, a -> (a > 100 && a < 999) && intService.isUniqueDigits(a));
    }
}
