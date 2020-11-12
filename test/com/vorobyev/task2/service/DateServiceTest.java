package com.vorobyev.task2.service;

import com.vorobyev.task2.entity.Month;
import com.vorobyev.task2.entity.Year;
import com.vorobyev.task2.report.DateReport;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class DateServiceTest {

    @Test
    public void getDaysCountTest(){
        Year year = new Year(2000);
        Month month = new Month(2);
        DateService service = new DateService();
        int dayCount = service.getDaysCount(year, month);
        assertEquals(dayCount, 29);
    }
}