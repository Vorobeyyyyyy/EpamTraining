package com.vorobyev.bookdao.exception;

public class DaoException extends Exception {
    public DaoException() {
        super();
    }

    public DaoException(String message) {
        super(message);
    }
}