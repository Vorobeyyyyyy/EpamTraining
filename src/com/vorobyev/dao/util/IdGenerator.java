package com.vorobyev.dao.util;

public class IdGenerator {
    private IdGenerator(){}

    private static long id = 1;

    private static final IdGenerator instance = new IdGenerator();

    public static IdGenerator getInstance(){
        return instance;
    }
    public long getNewId(){
        return id++;
    }
}
