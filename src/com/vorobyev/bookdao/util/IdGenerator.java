package com.vorobyev.bookdao.util;

public class IdGenerator {
    private static final IdGenerator instance = new IdGenerator();

    private long id;

    private IdGenerator(){
        id = 1;
    }

    public static IdGenerator getInstance(){
        return instance;
    }

    public long getNewId(){
        return id++;
    }
}
