package com.vorobyev.task1.main;

import com.vorobyev.task1.entity.digit.Digit;
import com.vorobyev.task1.entity.digit.DigitBuilder;
import com.vorobyev.task1.report.DigitReport;
import com.vorobyev.task1.service.DigitService;

public class ProjectMain {

    public static void main(String[] args) {
        int value = 127;
        DigitBuilder digitBuilder = new DigitBuilder();
        Digit digit1 = digitBuilder.lastDigit(value);
        DigitService service = new DigitService();
        Digit resultDigit = service.digitSqrLastDigit(digit1);
        DigitReport report = new DigitReport();
        report.sqrLastDigitReport(resultDigit);
    }
}
