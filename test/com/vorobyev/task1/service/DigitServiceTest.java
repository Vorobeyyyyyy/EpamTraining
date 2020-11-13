package com.vorobyev.task1.service;

import com.vorobyev.task1.entity.digit.Digit;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DigitServiceTest {

    @Test
    public void testDigitSqrLastDigit() {
        Digit digit1 = new Digit(7);
        DigitService service = new DigitService();
        Digit actual = service.digitSqrLastDigit(digit1);
        Digit expected = new Digit(9);
        Assert.assertEquals(actual, expected);
    }
}