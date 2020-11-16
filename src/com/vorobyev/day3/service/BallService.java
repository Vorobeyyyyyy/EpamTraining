package com.vorobyev.day3.service;

import com.vorobyev.day3.entity.Ball;
import com.vorobyev.day3.entity.Basket;

import java.awt.*;

public class BallService {
    public int basketWeight(Basket basket){
        int weight = 0;
        Ball[] balls = basket.getBalls();
        for (Ball ball : balls){
            weight += ball.getWeight();
        }
        return weight;
    }

    public int countColoredBalls(Basket basket, Color color){
        int count = 0;
        Ball[] balls = basket.getBalls();
        for (Ball ball : balls){
            if (ball.getColor() == color) {
                count++;
            }
        }
        return count;
    }
}
