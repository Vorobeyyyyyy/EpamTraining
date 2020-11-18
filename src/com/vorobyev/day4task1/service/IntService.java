package com.vorobyev.day4task1.service;

public class IntService {
    public boolean isSimple(int value){
        value = Math.abs(value);
        for (int i = 2; i < Math.sqrt(value); i++){
            if (value % i == 0)
                return false;
        }
        return true;
    }

    public boolean isFibonacci(int value){
        int prevValue = 1;
        int curValue = 1;
        while (value > curValue){
            int tempCurValue = curValue;
            curValue = prevValue + curValue;
            prevValue = tempCurValue;
        }
        return value == curValue;
    }

    public boolean isUniqueDigits(int value){
        String strValue = String.valueOf(value);
        if (strValue.length() == 1){
            return true;
        }
        boolean unique = true;
        for(int i = 0; i < strValue.length() - 1; i++){
            for (int j = i + 1; j < strValue.length(); j++){
                if (strValue.charAt(i) == strValue.charAt(j)){
                    unique = false;
                    break;
                }
            }
        }
        return unique;
    }
}
