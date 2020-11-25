package com.vorobyev.day5.input;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileScanner {
    public String readFile(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        Scanner fileScanner = new Scanner(file);
        StringBuilder text = new StringBuilder();
        boolean needNewline = false;
        while (fileScanner.hasNextLine()) {
            if(needNewline){
                text.append("\n");
            }
            text.append(fileScanner.nextLine());
            needNewline = true;
        }
        fileScanner.close();
        return text.toString();
    }
}
