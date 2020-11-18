package com.vorobyev.day4task1.exception;

public class SearchServiceException extends Exception {
    public SearchServiceException(){
        super();
    }

    public SearchServiceException(String message){
        super(message);
    }
}
