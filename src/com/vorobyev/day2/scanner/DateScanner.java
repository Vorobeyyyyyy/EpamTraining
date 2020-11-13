package com.vorobyev.day2.scanner;

import com.vorobyev.day2.service.DateService;

import java.util.Calendar;
import java.util.InputMismatchException;
import java.util.Scanner;

public class DateScanner {
    public Calendar readDateFromConsole() throws DateScannerException{
        Calendar date = Calendar.getInstance();
        Scanner scanner = new Scanner(System.in);
        try {
            int day = scanner.nextInt();
            int month = scanner.nextInt() - 1;
            int year = scanner.nextInt();
            DateService service = new DateService();
            if (!service.isCorrectDate(year, month, day)){
                throw new DateScannerException("Incorrect date");
            }
            date.set(year, month, day);
            return date;
        }
        catch (InputMismatchException exception) {
            throw new DateScannerException("InputMismatchException");
        }
    }
}
