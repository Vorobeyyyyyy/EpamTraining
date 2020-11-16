package com.vorobyev.day3.service;

import com.vorobyev.day3.entity.Ball;
import com.vorobyev.day3.entity.BallException;
import com.vorobyev.day3.entity.Basket;
import org.testng.annotations.Test;

import java.awt.*;

import static org.testng.Assert.*;

public class BallServiceTest {

    BallService service = new BallService();
    @Test
    public void testBasketWeight() {
        Ball[] balls = new Ball[0];
        try {
            balls = new Ball[]  {
                    new Ball(22, Color.BLACK),
                    new Ball(14, Color.BLUE),
                    new Ball(56, Color.RED)
            };        }
        catch (BallException ignored){};
        Basket basket = new Basket();
        for(Ball ball : balls){
            basket.addBall(ball);
        }
        int expected = 22 + 14 + 56;
        int actual = service.basketWeight(basket);
        assertEquals(actual, expected);
    }

    @Test
    public void testCountColoredBalls() {
        Ball[] balls = new Ball[0];
        try {
            balls = new Ball[]  {
                    new Ball(22, Color.BLACK),
                    new Ball(14, Color.BLUE),
                    new Ball(56, Color.RED)
            };
        }
        catch (BallException ignored){};
        Basket basket = new Basket();
        for(Ball ball : balls){
            basket.addBall(ball);
        }

        int expected = 1;
        int actual = service.countColoredBalls(basket, Color.BLUE);
        assertEquals(actual, expected);
    }
}