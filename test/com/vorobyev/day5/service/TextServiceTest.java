package com.vorobyev.day5.service;

import com.vorobyev.day5.input.FileScanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;

import static org.testng.Assert.*;

public class TextServiceTest {
    private static final Logger logger = LogManager.getLogger();
    private static final String FILE_PATH = "res/day5/text.txt";
    private String text;
    private TextService textService = new TextService();

    @BeforeMethod
    public void beforeMethod(){
        try{
            FileScanner scanner = new FileScanner();
            text = scanner.readFile(FILE_PATH);
        }
        catch (FileNotFoundException exception){
            logger.error("Text file ({}) not found!", FILE_PATH);
            text = "";
        }
    }

    @Test
    public void testReplaceSymbolInWords() {
        String actual = textService.replaceSymbolInWords(text, 3, 'H');
        String expected = "ThiH is tesH texH filH. HelHo worHd. JavH ./\\oraHle sttH epaH.comHany";
        assertEquals(actual, expected);
    }

    @Test
    public void testReplaceWrongSymbol() {
        String actual = textService.replaceWrongSymbol(text, 'x', 't', 'U');
        String expected = "This is test texU file. Hello world. Java ./\\oracle stty epam.company";
        assertEquals(actual, expected);
    }

    @Test
    public void testReplaceWordWithLengthBySubstring() {
        String actual = textService.replaceWordWithLengthBySubstring(text, 4, "SUB");
        String expected = "This is test texU file. Hello world. Java ./\\oracle stty epam.company";
        assertEquals(actual, expected);
    }

    @Test
    public void testRemoveNonWordSymbols() {
    }

    @Test
    public void testDeleteConsonantWordWithLength() {
    }
}