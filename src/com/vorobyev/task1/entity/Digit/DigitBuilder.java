package com.vorobyev.task1.entity.Digit;

public class DigitBuilder {
    public Digit lastDigit(int value){
        return new Digit(Math.abs(value % 10));
    }
}
