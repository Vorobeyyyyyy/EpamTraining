package com.vorobyev.dao.exception;

public class ServiceException extends Exception {
    public ServiceException() {
        super();
    }

    public ServiceException(String message) {
        super(message);
    }
}
