package com.vorobyev.bookdao.validator;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BookValidator {
    private static final Logger logger = LogManager.getLogger();

    private static final String BOOK_LABEL_REGEX = "[A-Za-z-!.,0-9\\s]{1,30}";
    private static final String AUTHOR_NAME_REGEX = "[A-Za-z-]{1,25}\\s[A-Za-z-]{1,25}";
    private static final int MIN_YEAR = 1800;
    private static final int MAX_YEAR = 2100;

    private BookValidator(){}

    public static boolean isLabelValid(String label) {
        if (label == null) {
            return false;
        }
        Pattern pattern = Pattern.compile(BOOK_LABEL_REGEX);
        Matcher matcher = pattern.matcher(label);
        boolean result = matcher.matches();
        logger.log(Level.INFO, "Label {} valid: {}", label, result);
        return result;
    }

    public static boolean isAuthorNameValid(String name) {
        if (name == null) {
            return false;
        }
        Pattern pattern = Pattern.compile(AUTHOR_NAME_REGEX);
        Matcher matcher = pattern.matcher(name);
        boolean result = matcher.matches();
        logger.log(Level.INFO, "Author name: {} valid: {}", name, result);
        return result;
    }

    public static boolean isAuthorNamesValid(Set<String> names) {
        Stream<String> namesStream = names.stream();
        namesStream =  namesStream.filter(BookValidator::isAuthorNameValid);
        Set<String> namesSet = namesStream.collect(Collectors.toSet());
        return names.size() == namesSet.size();
    }

    public static boolean isPublishYearValid(int year) {
        boolean result = year > MIN_YEAR && year <= MAX_YEAR;
        logger.log(Level.INFO, "Publish year: {} valid: {}", year, result);
        return result;
    }
}
