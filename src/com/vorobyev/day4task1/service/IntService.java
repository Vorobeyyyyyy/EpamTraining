package com.vorobyev.day4task1.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class IntService {
    private static final Logger logger = LogManager.getLogger();

    public boolean isSimple(int value) {
        value = Math.abs(value);
        boolean result = true;
        for (int i = 2; i < Math.sqrt(value); i++) {
            if (value % i == 0) {
                result = false;
                break;
            }
        }
        logger.info("In simple value: {} result: {}", value, result);
        return result;
    }

    public boolean isFibonacci(int value) {
        int prevValue = 1;
        int curValue = 1;
        while (value > curValue) {
            int tempCurValue = curValue;
            curValue = prevValue + curValue;
            prevValue = tempCurValue;
        }
        boolean result = value == curValue;
        logger.info("In isFibonacci value: {} result: {}", value, result);
        return result;
    }

    public boolean isUniqueDigits(int value) {
        String strValue = String.valueOf(value);
        if (strValue.length() == 1) {
            return true;
        }
        boolean unique = true;
        for (int i = 0; i < strValue.length() - 1; i++) {
            for (int j = i + 1; j < strValue.length(); j++) {
                if (strValue.charAt(i) == strValue.charAt(j)) {
                    unique = false;
                    break;
                }
            }
        }
        logger.info("In isUniqueDigits value: {} result: {}", value, unique);
        return unique;
    }
}
