package com.vorobyev.task2.main;

import com.vorobyev.task2.entity.Month;
import com.vorobyev.task2.entity.Year;
import com.vorobyev.task2.report.DateReport;
import com.vorobyev.task2.service.DateService;

public class ProjectMain {

    public static void main(String[] args) {
        Year year = new Year(2000);
        Month month = new Month(2);
        DateService service = new DateService();
        int dayCount = service.getDaysCount(year, month);
        DateReport dateReport = new DateReport();
        dateReport.daysCountReport(dayCount);
    }

}
