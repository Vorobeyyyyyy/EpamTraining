package com.vorobyev.day3.entity;
import java.util.Arrays;

public class Basket {
    private Ball[] balls;

    public Basket(){
        balls = new Ball[0];
    }

    public void addBall(Ball ball){
        if(isExists(ball)) {
            return;
        }
        balls = Arrays.copyOf(balls, balls.length + 1);
        int lastIndex = balls.length - 1;
        balls[lastIndex] = ball;
    }

    public boolean isExists(Ball ball){
        for (Ball anotherBall : balls){
            if (anotherBall == ball)
                return true;
        }
        return false;
    }

    public Ball[] getBalls() {
        return Arrays.copyOf(balls, balls.length);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Basket basket = (Basket) o;
        return Arrays.equals(balls, basket.balls);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(balls);
    }
}
