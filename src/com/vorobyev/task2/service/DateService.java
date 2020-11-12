package com.vorobyev.task2.service;

import com.vorobyev.task2.entity.Month;
import com.vorobyev.task2.entity.Year;

public class DateService {
    private final int[] daysCountArray = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    boolean isLeapYear(Year year){
        int yearInt = year.getYearValue();
        return yearInt % 4 == 0 && (yearInt % 100 != 0 || (yearInt % 100 == 0 && yearInt % 400 == 0));
    }

    public int getDaysCount(Year year, Month month){
        int monthNumber = month.getMonthNumber();
        int leapModifier = (monthNumber == 2 && isLeapYear(year) ? 1 : 0);
        return daysCountArray[monthNumber - 1] + leapModifier;
    }
}
