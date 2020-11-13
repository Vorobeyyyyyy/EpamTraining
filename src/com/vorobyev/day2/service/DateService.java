package com.vorobyev.day2.service;
import com.vorobyev.day2.scanner.DateScannerException;

import java.time.DayOfWeek;
import java.time.format.TextStyle;
import java.util.Calendar;
import java.util.Locale;

public class DateService {

    public boolean isTodayBirthday(Calendar date) {
        Calendar today = Calendar.getInstance();
        int todayDay = today.get(Calendar.DATE);
        int dateDay = date.get(Calendar.DATE);
        if (todayDay == dateDay) {
            return true;
        }
        int todayMonth = today.get(Calendar.YEAR);
        int dateMonth = date.get(Calendar.MONTH);

        return todayMonth == dateMonth;
    }

    public String dayNameFromDate(Calendar date, Locale locale) {
        int dayOfWeek = date.get(Calendar.DAY_OF_WEEK);
        int firstDayOffset = 1;
        int realDayOfWeek = dayOfWeek - firstDayOffset;
        if (realDayOfWeek == 0)
            realDayOfWeek = 7;
        DayOfWeek day = DayOfWeek.of(realDayOfWeek);
        return day.getDisplayName(TextStyle.FULL, locale);
    }

    public boolean isCorrectDate(int year, int month, int day) {
        if (year < 0){
            return false;
        }
        if (month < 1 || month > 12) {
            return false;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month);
        int daysInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        return day <= daysInMonth && day > 0;

    }
}
