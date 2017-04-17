package main.java.edu.measure.controller;


import java.util.*;

/**
 * Contains cosinus measure calculations logic
 */
public class MeasureCalculator {
    public void mergeMaps(Map<String, Integer> firstMap, Map<String, Integer> secondMap) {
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
        System.out.println(result);
    }
}
