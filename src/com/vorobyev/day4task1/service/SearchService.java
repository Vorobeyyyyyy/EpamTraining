package com.vorobyev.day4task1.service;

import com.vorobyev.day4task1.entity.Array;
import com.vorobyev.day4task1.exception.SearchServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.function.IntPredicate;

public class SearchService {
    private static final Logger logger = LogManager.getLogger();

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
            logger.warn("No such element exception");
            throw new SearchServiceException("No such element");
        }
        logger.info("Found element {} in pos {}", value, pos);
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
        logger.info("Found min value {}", min);
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
        logger.info("Found max value {}", max);
        return max;
    }

    public Array findAll(Array array, IntPredicate intPredicate){
        Array simpleArray = new Array();
        for(int a : array.getArray()){
            if (intPredicate.test(a)){
                simpleArray.add(a);
            }
        }
        logger.info("Found all values");
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
