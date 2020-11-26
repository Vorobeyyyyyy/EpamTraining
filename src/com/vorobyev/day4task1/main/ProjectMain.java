package com.vorobyev.day4task1.main;

import com.vorobyev.day4task1.entity.Array;
import com.vorobyev.day4task1.exception.ArrayScannerException;
import com.vorobyev.day4task1.report.ArrayReport;
import com.vorobyev.day4task1.report.ExceptionReport;
import com.vorobyev.day4task1.scanner.ArrayScanner;
import com.vorobyev.day4task1.creator.ArrayGenerator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class ProjectMain {
    private static final Logger logger = LogManager.getLogger();
    private static final String FILE_PATH = "res/day4/array.txt";


    public static void main(String[] args) {
        logger.info("Program started");
        ArrayReport report = new ArrayReport();
        ArrayScanner arrayScanner = new ArrayScanner();
        try {
            Array array = arrayScanner.fromFile(FILE_PATH);
            report.arrayFromFile(array);
        }
        catch (ArrayScannerException exception)
        {
            ExceptionReport exceptionReport = new ExceptionReport();
            exceptionReport.scanner(exception.getMessage());
        }

        ArrayGenerator generator = new ArrayGenerator();
        Array randomArray = generator.random(10,100);
        report.randomArray(randomArray);
        logger.info("Program ended");
    }
}
