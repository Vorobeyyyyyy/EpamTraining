package com.vorobyev.day4task1.scanner;

import com.vorobyev.day4task1.entity.Array;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ArrayScanner {
    private static final Logger logger = LogManager.getLogger();

    public Array fromConsole(){
        Scanner consoleScanner = new Scanner(System.in);
        Array array = new Array();
        int size = consoleScanner.nextInt();
        while (size-- != 0){
            int value = consoleScanner.nextInt();
            array.add(value);
        }

        logger.info("Read array from console with size {}", size);
        return array;
    }

    public Array fromFile(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        Scanner fileScanner = new Scanner(file);
        Array array = new Array();
        while (fileScanner.hasNextInt()){
            array.add(fileScanner.nextInt());
        }
        fileScanner.close();
        logger.info("Read array from console with size {}", array.size());
        return array;
    }
}
