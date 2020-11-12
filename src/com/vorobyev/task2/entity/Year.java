package com.vorobyev.task2.entity;

public class Year {
    private int yearValue;

    public Year(int year){
        setYearValue(year);
    }

    public int getYearValue() {
        return yearValue;
    }

    public void setYearValue(int yearValue) {
        if (yearValue <= 0){
            throw new DateException("Year is not valid");
        }
        else{
            this.yearValue = yearValue;
        }
    }



}
