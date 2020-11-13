package com.vorobyev.task1.service;

import com.vorobyev.task1.entity.digit.Digit;
import com.vorobyev.task1.entity.digit.DigitBuilder;

public class DigitService {

    public Digit digitSqrLastDigit(Digit digit) {
        int sqrValue = (int)Math.pow(digit.getValue(), 2f);
        DigitBuilder builder = new DigitBuilder();
        return builder.lastDigit(sqrValue);
    }
}
