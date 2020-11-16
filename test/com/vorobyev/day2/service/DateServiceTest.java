package com.vorobyev.day2.service;

import com.vorobyev.day2.scanner.DateScanner;
import org.testng.annotations.Test;

import java.util.Calendar;
import java.util.Locale;

import static org.testng.Assert.*;

public class DateServiceTest {
    DateService dateService = new DateService();

    @Test
    public void testIsTodayBirthday() {

        Calendar date = Calendar.getInstance();
        boolean actual = dateService.isTodayBirthday(date);
        assertTrue(actual);
    }

    @Test
    public void testDayNameFromDate() {
        Calendar date = Calendar.getInstance();
        date.set(2020, 10, 14);
        String expected = "Saturday";
        String actual = dateService.dayNameFromDate(date, Locale.ENGLISH);
        assertEquals(actual, expected);
    }

    @Test
    public void testIsCorrectDate() {
        boolean actual = dateService.isCorrectDate(2020, 12, 4);
        assertTrue(actual);
    }

    @Test
    public void testIsCorrectDate1() {
        boolean actual = dateService.isCorrectDate(2020, 11, 31);
        assertFalse(actual);
    }

    @Test
    public void testIsCorrectDate2() {
        boolean actual = dateService.isCorrectDate(2019, 2, 29);
        assertFalse(actual);
    }
}