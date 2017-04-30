package edu.measure.controller;

import java.util.List;
import java.util.Map;

/**
 * Contains matrix of cosine measures calculations logic
 */
public class MeasureMatrixCalculator {
    public double[][] matrixCalculator(List<Map<String,Integer>> list)
    {
        MeasureCalculator measureCalculator = new MeasureCalculator();
        double[][] returnArray = new double[list.size()][list.size()];
        for(int i=0;i<list.size();i++)
        {
            for(int j=0;j<list.size();j++)
            {
                returnArray[i][j]=0.0;
            }
        }
        for(int i=0;i<list.size();i++)
        {
            for(int j=0;j<list.size();j++)
            {
                returnArray[i][j]= measureCalculator.mergeMaps(list.get(i),list.get(j));
            }
        }



        return returnArray;
    }
}
