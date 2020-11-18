package com.vorobyev.day4task2.main;

import com.vorobyev.day4task2.comparator.ComparatorByMaxMax;
import com.vorobyev.day4task2.comparator.ComparatorByMaxMin;
import com.vorobyev.day4task2.comparator.ComparatorBySum;
import com.vorobyev.day4task2.report.JaggedReport;
import com.vorobyev.day4task2.service.JaggedArrayService;
import com.vorobyev.day4task2.util.JaggedRandomGenerator;

public class ProjectMain {
    public static void main(String[] args) {
        JaggedRandomGenerator generator = new JaggedRandomGenerator();
        int[][] array1 = generator.generate();
        int[][] array2 = array1.clone();
        int[][] array3 = array1.clone();
        JaggedArrayService service = new JaggedArrayService();
        ComparatorBySum comparatorBySum = new ComparatorBySum();
        ComparatorByMaxMax comparatorByMaxMax = new ComparatorByMaxMax();
        ComparatorByMaxMin comparatorByMaxMin = new ComparatorByMaxMin();
        service.sort(array1, comparatorBySum, true);
        service.sort(array2, comparatorByMaxMax, true);
        service.sort(array3, comparatorByMaxMin, false);
        JaggedReport report = new JaggedReport();
        report.sortedBySum(array1);
        report.sortedByMaxMax(array2);
        report.sortedByMaxMin(array3);
    }
}
