package edu.measure.controller;

import edu.measure.view.util.ViewPrinter;

import java.util.List;
import java.util.Map;

/**
 * logic of recall-precision-f1 calculations
 */
public class RecallPrecisionCalculator {
    private double edgesComparator(boolean[] expertEdges, boolean[] customEdges) {
        int fTreshhold;
        double truePositives=0;
        double falsePositives=0;
        double falseNegatives=0;
        double trueNegatives=0;
        double recall=0;
        double precision=0;
        double fOne=0;
        double accuracy=0;

        for (int i = 0; i < expertEdges.length; i++) {
            if(expertEdges[i] && customEdges[i])
            {
                truePositives++;
            }
            if(customEdges[i] && !expertEdges[i])
            {
                falsePositives++;
            }
            if(!customEdges[i] && expertEdges[i])
            {
                falseNegatives++;
            }
            if(!customEdges[i] && !expertEdges[i])
            {
                trueNegatives++;
            }
        }
        recall=truePositives/(truePositives+falseNegatives);
        precision=truePositives/(truePositives+falsePositives);
        fOne=(2*recall*precision)/(recall+precision);
        accuracy=(truePositives+trueNegatives)/(truePositives+trueNegatives+falsePositives+falseNegatives);
        return fOne;
    }
    public String cosineEdgeComparator(List<Map<String, Integer>> list, Map<String,Double> calculatedMap)
    {
        ParahsEdgeCounter parahsEdgeCounter = new ParahsEdgeCounter();
        double bestEdge = 0;
        double compareResult,bestResult=0;
        boolean[] expertEdges = parahsEdgeCounter.expertEdgeChecker(list,list.size());
        boolean[] customEdges;
        for(double edge=0.1;edge<1;edge=edge+0.001)
        {
            customEdges = parahsEdgeCounter.customEdgeChecker(calculatedMap,calculatedMap.size(),edge);
            compareResult = edgesComparator(expertEdges,customEdges);
            if(compareResult>bestResult)
            {
                bestEdge=edge;
                bestResult=compareResult;
            }
            System.out.println("Edge: "+edge+" Result: "+compareResult);
        }
        String resulted="Best edge: "+bestEdge+" Best compare result "+bestResult;
        customEdges=parahsEdgeCounter.customEdgeChecker(calculatedMap,calculatedMap.size(),bestEdge);
        new ViewPrinter().printBooleanArrayToFile(customEdges,"bestEdges.txt");
        new ViewPrinter().printBooleanArrayToFile(expertEdges,"expertEdges.txt");
        return resulted;
    }
}
