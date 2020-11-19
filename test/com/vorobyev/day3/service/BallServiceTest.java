package com.vorobyev.day3.service;

import com.vorobyev.day3.entity.Ball;
import com.vorobyev.day3.entity.BallException;
import com.vorobyev.day3.entity.Basket;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.awt.*;

import static org.testng.Assert.*;

public class BallServiceTest {
    BallService service = new BallService();

    Basket basket;
    @BeforeTest
    public void initBasket(){
        Ball[] balls = new Ball[0];
        try {
            balls = new Ball[]  {
                    new Ball(22, Color.BLACK),
                    new Ball(14, Color.BLUE),
                    new Ball(56, Color.RED)
            };        }
        catch (BallException ignored){};
        basket = new Basket();
        for(Ball ball : balls){
            basket.addBall(ball);
        }
    }

    @Test
    public void testBasketWeight() {
        int expected = 22 + 14 + 56;
        int actual = service.basketWeight(basket);
        assertEquals(actual, expected);
    }

    @Test
    public void testCountColoredBalls() {
        int expected = 1;
        int actual = service.countColoredBalls(basket, Color.BLUE);
        assertEquals(actual, expected);
    }
}