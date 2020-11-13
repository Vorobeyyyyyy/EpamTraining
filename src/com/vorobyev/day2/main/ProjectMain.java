package com.vorobyev.day2.main;

import com.vorobyev.day2.report.DateReport;
import com.vorobyev.day2.report.ExceptionReport;
import com.vorobyev.day2.scanner.DateScanner;
import com.vorobyev.day2.scanner.DateScannerException;
import com.vorobyev.day2.service.DateService;

import java.util.Calendar;
import java.util.Locale;

public class ProjectMain {
    public static void main(String[] args) {
        DateReport report = new DateReport();
        report.askToEnterDate();
        DateScanner scanner = new DateScanner();
        Calendar birthdayDate;
        try {
            birthdayDate = scanner.readDateFromConsole();
        }
        catch (DateScannerException exception){
            ExceptionReport exceptionReport = new ExceptionReport();
            exceptionReport.printInputErrorMessage(exception.getMessage());
            return;
        }
        DateService service = new DateService();
        boolean todayBirthday = service.isTodayBirthday(birthdayDate);
        if (todayBirthday){
            report.happyBirthday();
        }
        String weekDayBirthday = service.dayNameFromDate(birthdayDate, Locale.ENGLISH);
        report.weekDayBirthday(weekDayBirthday);
    }
}
