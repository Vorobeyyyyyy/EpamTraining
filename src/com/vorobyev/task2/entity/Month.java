package com.vorobyev.task2.entity;

public class Month {
    private int monthNumber;

    public Month(int month){
        setMonthNumber(month);
    }

    public int getMonthNumber() {
        return monthNumber;
    }

    public void setMonthNumber(int month) {
        if (month < 1 || month > 12){
            throw new DateException("Not a month");
        }
        else {
            this.monthNumber = month;
        }
    }


}
