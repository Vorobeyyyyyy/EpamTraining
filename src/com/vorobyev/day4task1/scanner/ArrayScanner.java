package com.vorobyev.day4task1.scanner;

import com.vorobyev.day4task1.entity.Array;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ArrayScanner {

    public Array fromConsole(){
        Scanner consoleScanner = new Scanner(System.in);
        Array array = new Array();
        int size = consoleScanner.nextInt();
        while (size-- != 0){
            int value = consoleScanner.nextInt();
            array.add(value);
        }
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
        return array;
    }
}
