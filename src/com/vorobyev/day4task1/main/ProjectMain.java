package com.vorobyev.day4task1.main;

import com.vorobyev.day4task1.entity.Array;
import com.vorobyev.day4task1.report.ArrayReport;
import com.vorobyev.day4task1.report.ExceptionReport;
import com.vorobyev.day4task1.scanner.ArrayScanner;
import com.vorobyev.day4task1.util.ArrayGenerator;

import java.io.FileNotFoundException;

public class ProjectMain {
    public static void main(String[] args) {
        ArrayReport report = new ArrayReport();
        ArrayScanner arrayScanner = new ArrayScanner();
        try {
            Array array = arrayScanner.fromFile("res/day4/array.txt");
            report.arrayFromFile(array);
        }
        catch (FileNotFoundException exception)
        {
            ExceptionReport exceptionReport = new ExceptionReport();
            exceptionReport.fileNotFound(exception.getMessage());
        }

        ArrayGenerator generator = new ArrayGenerator();
        Array randomArray = generator.random(10,100);
        report.randomArray(randomArray);
    }
}
