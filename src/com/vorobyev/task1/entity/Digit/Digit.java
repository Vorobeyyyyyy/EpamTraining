package com.vorobyev.task1.entity.Digit;

public class Digit {
    private int value;

    public Digit(int value) throws DigitException {
        setValue(value);
    }

    public int getValue(){
        return value;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Digit{");
        sb.append("value=").append(value);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Digit digit = (Digit) o;

        return value == digit.value;
    }

    @Override
    public int hashCode() {
        return value;
    }

    public void setValue(int value){
        if (value < 0 || value > 9) {
            throw new DigitException("Not a digit");
        } else {
            this.value = value;
        }
    }
};

