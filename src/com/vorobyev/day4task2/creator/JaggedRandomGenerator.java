package com.vorobyev.day4task2.creator;

import com.vorobyev.day4task2.util.ProjectRandom;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class JaggedRandomGenerator {
    private static final Logger logger = LogManager.getLogger();

    public int[][] generate(){
        int size1 = ProjectRandom.random.nextInt(5) + 3;
        int[][] array = new int[size1][];
        for(int i = 0; i < size1; i++){
            int size2 = ProjectRandom.random.nextInt(5) + 3;
            array[i] = new int[size2];
            for (int j = 0; j < size2; j++){
                int value = ProjectRandom.random.nextInt(30);
                array[i][j] = value;
            }
        }
        logger.info("Generated with size {}", size1);
        return array;
    }
}
