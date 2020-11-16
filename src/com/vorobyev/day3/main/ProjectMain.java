package com.vorobyev.day3.main;

import com.vorobyev.day3.entity.Ball;
import com.vorobyev.day3.entity.BallException;
import com.vorobyev.day3.entity.Basket;
import com.vorobyev.day3.report.BasketReport;
import com.vorobyev.day3.report.ExceptionReport;
import com.vorobyev.day3.service.BallService;

import java.awt.*;

public class ProjectMain {

    public static void main(String[] args) {
        Basket basket = new Basket();

        Ball[] balls;
        try {
            balls = new Ball[]  {
            new Ball(22, Color.BLACK),
            new Ball(14, Color.BLUE),
            new Ball(56, Color.RED)
            };
        }
        catch (BallException exception){
            ExceptionReport exceptionReport = new ExceptionReport();
            exceptionReport.wrongWeight(exception.getMessage());
            return;
        }
        for(Ball ball : balls){
            basket.addBall(ball);
        }
        BallService ballService = new BallService();
        int weight = ballService.basketWeight(basket);
        BasketReport basketReport = new BasketReport();
        basketReport.basketWeight(weight);
        int blueCount = ballService.countColoredBalls(basket, Color.BLUE);
        basketReport.blueBallsCount(blueCount);
    }
}
