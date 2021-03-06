package edu.measure.controller.cosine;


import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/**
 * Contains cosinus edu.measure calculations logic
 */
public class MeasureCalculator {
    public double mergeMaps(Map<String, Integer> firstMap, Map<String, Integer> secondMap) {
        Set<String> intersection = new LinkedHashSet<>(firstMap.keySet());
        intersection.retainAll(secondMap.keySet());
        double result;
        double dotProduct = 0, magnitudeA = 0, magnitudeB = 0;
        for (String item : intersection) {
            dotProduct += firstMap.get(item) * secondMap.get(item);
        }
        for (String k : firstMap.keySet()) {
            magnitudeA += Math.pow(firstMap.get(k), 2);
        }

        for (String k : secondMap.keySet()) {
            magnitudeB += Math.pow(secondMap.get(k), 2);
        }

        result = dotProduct / Math.sqrt(magnitudeA * magnitudeB);
        return result;
    }
}
