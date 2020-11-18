package com.vorobyev.day4task2.util;

public class JaggedRandomGenerator {
    public int[][] generate(){
        int size1 = ProjectRandom.random.nextInt(3) + 3;
        int[][] array = new int[size1][];
        for(int i = 0; i < size1; i++){
            int size2 = ProjectRandom.random.nextInt(3) + 3;
            array[i] = new int[size2];
            for (int j = 0; j < size2; j++){
                int value = ProjectRandom.random.nextInt(30);
                array[i][j] = value;
            }
        }
        return array;
    }
}
