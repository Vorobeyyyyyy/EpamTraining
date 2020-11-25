package com.vorobyev.day4task1.creator;

import com.vorobyev.day4task1.entity.Array;
import com.vorobyev.day4task1.util.ProjectRandom;

import java.util.Random;

public class ArrayGenerator {
    public Array random(int size, int bound){
        Array array = new Array();
        Random random = ProjectRandom.random;
        while(size-- != 0){
            int value = random.nextInt(bound);
            array.add(value);
        }
        return array;
    }
}
