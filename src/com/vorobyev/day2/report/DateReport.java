package com.vorobyev.day2.report;

import java.time.DayOfWeek;
import java.util.Calendar;

public class DateReport {

    public void happyBirthday(){
        System.out.println("Happy birthday!");
    }

    public void weekDayBirthday(String day) {
        System.out.println("You was born on " + day);
    }

    public void askToEnterDate(){
        System.out.println("Enter date in format DAY MONTH YEAR (Ex: 3 8 2001):");
    }
}
