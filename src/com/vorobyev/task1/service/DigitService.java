package com.vorobyev.task1.service;

import com.vorobyev.task1.entity.Digit.Digit;
import com.vorobyev.task1.entity.Digit.DigitBuilder;

public class DigitService {

    public Digit digitSqrLastDigit(Digit digit)
    {
        int sqrValue = (int)Math.pow(digit.getValue(), 2f);
        DigitBuilder builder = new DigitBuilder();
        Digit result = builder.lastDigit(sqrValue);
        return result;
    }
}
