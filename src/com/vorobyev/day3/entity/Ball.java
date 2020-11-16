package com.vorobyev.day3.entity;

import java.awt.*;

public class Ball {
    private int weight;
    private Color color;

    public Ball(int weight, Color color) throws BallException {
        setWeight(weight);
        setColor(color);
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) throws BallException {
        if (weight <= 0){
            throw new BallException("Ball weight (" + weight + ") is not positive");
        }
        this.weight = weight;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ball ball = (Ball) o;

        if (weight != ball.weight) return false;
        return color.equals(ball.color);
    }

    @Override
    public int hashCode() {
        int result = weight;
        result = 31 * result + color.hashCode();
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Ball{");
        sb.append("weight=").append(weight);
        sb.append(", color=").append(color);
        sb.append('}');
        return sb.toString();
    }
}
