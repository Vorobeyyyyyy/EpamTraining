package com.vorobyev.day4task1.scanner;

import com.vorobyev.day4task1.entity.Array;
import com.vorobyev.day4task1.exception.ArrayScannerException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ArrayScanner {
    private static final Logger logger = LogManager.getLogger();

    public Array fromConsole() throws ArrayScannerException{
        Scanner consoleScanner = new Scanner(System.in);
        Array array = new Array();
        int size = 0;
        try {
            size = consoleScanner.nextInt();
            while (size-- != 0) {
                int value = consoleScanner.nextInt();
                array.add(value);
            }
        }
        catch (IllegalStateException | NoSuchElementException exception){
            logger.error("{} : {}", exception, exception.getMessage());
            throw new ArrayScannerException(exception.getMessage());
        }
        finally {
            consoleScanner.close();
        }
        logger.info("Read array from console with size {}", size);
        return array;
    }

    public Array fromFile(String fileName) throws ArrayScannerException {
        File file = new File(fileName);
        Scanner fileScanner;
        Array array = new Array();
        try {
            fileScanner = new Scanner(file);
        }
        catch (FileNotFoundException exception){
            logger.error(exception.getMessage());
            throw new ArrayScannerException(exception.getMessage());
        }

        try{
            while (fileScanner.hasNextInt()) {
                array.add(fileScanner.nextInt());
            }
        }
        catch (IllegalStateException | NoSuchElementException exception){
            logger.error("{} : {}", exception, exception.getMessage());
            throw new ArrayScannerException(exception.getMessage());
        }
        finally {
            fileScanner.close();
        }
        logger.info("Read array from file with size {}", array.size());
        return array;
    }
}
