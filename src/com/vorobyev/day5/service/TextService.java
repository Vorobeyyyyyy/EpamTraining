package com.vorobyev.day5.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.regex.Pattern;

public class TextService {
    private static final Logger logger = LogManager.getLogger();

    public String replaceSymbolInWords(String text, int pos, char symbol){
        char[] chars = text.toCharArray();
        int posInWord = 0;
        for (int i = 0; i < chars.length; i++) {
            if (!(chars[i] >= 'a' && chars[i] <= 'z' || chars[i] >= 'A' && chars[i] <= 'Z')){
                posInWord = 0;
                logger.debug("Pos counter was set to zero at pos {}", i);
                continue;
            }
            if (posInWord == pos){
                chars[i] = symbol;
                logger.debug("Symbol was replaced at pos {}", i);
            }
            posInWord++;
        }
        logger.info("Successful replace!");
        return new String(chars);
    }

    public String replaceWrongSymbol(String text, char base, char wrong, char correct){
        String wrongPair = String.valueOf(base) + wrong;
        String correctPair = String.valueOf(base) + correct;
        text = text.replaceAll(wrongPair, correctPair);
        logger.info("Successful replace! ({} -> {})", wrongPair, correctPair);
        return text;
    }

    public String replaceWordWithLengthBySubstring(String text, int length, String substring){
        StringBuilder regex = new StringBuilder("\\w{");
        regex.append(length);
        regex.append("}");
        text = text.replaceAll(regex.toString(), substring);
        logger.info("Successful replace!");
        return text;
    }

    public String removeNonWordSymbols(String text){
        String nonWordSymbolRegex = "\\W";
        String spacesRegex = "( )+";
        text = text.replaceAll(nonWordSymbolRegex, " ");
        text = text.replaceAll(spacesRegex, " ");
        logger.info("Successful remove!");
        return text;
    }

    public String deleteConsonantWordWithLength(String text, int length){
        String[] words = text.split("\\W");
        logger.debug("Text was split on {} words", words.length);
        StringBuilder regex = new StringBuilder("[\\w^aeiouAEIOU\\d].{");
        regex.append(length - 1);
        regex.append("}");
        Pattern wordPattern =  Pattern.compile(regex.toString());
        StringBuilder result = new StringBuilder();
        for (String word : words){
            if(!wordPattern.matcher(word).matches()){
                result.append(word);
                logger.debug("Word {} appended", word);
            }
        }
        return  result.toString();
    }
}
