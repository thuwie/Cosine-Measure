package edu.measure.controller.cosine.delimeters;

import java.util.HashMap;
import java.util.Map;

import static edu.measure.controller.util.Constants.*;

/**
 * class container for command map executors
 */
public class DelimiterExecutors {
    double fOneCommand(boolean[] expertEdges, boolean[] customEdges) {
        Map<String, Double> resultMap;
        resultMap = util(expertEdges, customEdges);
        return resultMap.get(FONE_OPTION);
    }

    double accuracyCommand(boolean[] expertEdges, boolean[] customEdges) {
        Map<String, Double> resultMap;
        resultMap = util(expertEdges, customEdges);
        return resultMap.get(ACCURACY_OPTION);
    }

    double recallCommand(boolean[] expertEdges, boolean[] customEdges) {
        Map<String, Double> resultMap;
        resultMap = util(expertEdges, customEdges);
        return resultMap.get(RECALL_OPTION);
    }

    double precisionCommand(boolean[] expertEdges, boolean[] customEdges) {
        Map<String, Double> resultMap;
        resultMap = util(expertEdges, customEdges);
        return resultMap.get(PRECISION_OPTION);
    }

    double expertEdgeCommand(boolean[] expertEdges) {
        double min = 1.0;
        double temp;
        for (int i = 0; i < expertEdges.length - 1; i++) {
            if (expertEdges[i]) {
                temp = finalMap.get(""+i);
                if (temp < min) {
                    min = temp;
                }
            }
        }
        return min;
    }

    private Map<String, Double> util(boolean[] expertEdges, boolean[] customEdges) {
        Map<String, Double> resultMap = new HashMap<>();
        double truePositives = 0;
        double falsePositives = 0;
        double falseNegatives = 0;
        double trueNegatives = 0;
        double recall;
        double precision;
        double fOne;
        double accuracy;

        for (int i = 0; i < expertEdges.length; i++) {
            if (expertEdges[i] && customEdges[i]) {
                truePositives++;
            }
            if (customEdges[i] && !expertEdges[i]) {
                falsePositives++;
            }
            if (!customEdges[i] && expertEdges[i]) {
                falseNegatives++;
            }
            if (!customEdges[i] && !expertEdges[i]) {
                trueNegatives++;
            }
        }
        recall = truePositives / (truePositives + falseNegatives);
        precision = truePositives / (truePositives + falsePositives);
        fOne = (2 * recall * precision) / (recall + precision);
        accuracy = (truePositives + trueNegatives) / (truePositives + trueNegatives + falsePositives + falseNegatives);
        resultMap.put(RECALL_OPTION, recall);
        resultMap.put(PRECISION_OPTION, precision);
        resultMap.put(FONE_OPTION, fOne);
        resultMap.put(ACCURACY_OPTION, accuracy);
        return resultMap;
    }
}
