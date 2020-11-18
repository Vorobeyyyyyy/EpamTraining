package com.vorobyev.day4task1.entity;

import com.vorobyev.day4task1.exception.ArrayException;

import java.util.Arrays;

public class Array {
    private int[] values;

    public Array(){
        values = new int[0];
    }

    public Array(int size){
        values = new int[size];
    }

    public Array(int[] array){
        this.values = array.clone();
    }

    public int get(int index) throws ArrayException{
        if (index < 0 || index >= values.length){
            throw new ArrayException("Index out of bounds");
        }
        return values[index];
    }

    public int[] getArray(){
        return values.clone();
    }

    public void set(int index, int value) throws ArrayException{
        if (index < 0 || index >= values.length){
            throw new ArrayException("Index out of bounds");
        }
        values[index] = value;
    }

    public void add(int value){
        values = Arrays.copyOf(values, values.length + 1);
        int lastIndex = values.length - 1;
        values[lastIndex] = value;
    }

    public int size(){
        return values.length;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Array{");
        sb.append("array=").append(Arrays.toString(values));
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Array array1 = (Array) o;

        return Arrays.equals(values, array1.values);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(values);
    }
}
