package edu.measure.controller.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Contains logic for arrays fillment with edges
 */
public class DivisionMarker {
    public boolean[] expertEdgeChecker(List<Map<String, Integer>> list, int size) {
        boolean[] edges = new boolean[size];
        int currPos = 1;
        for (Map<String, Integer> map : list) {
            List<String> listParah = new ArrayList<String>(map.keySet());
            if (isUpperCase(listParah.get(1))) {
                edges[currPos] = true;
            }
            currPos++;
        }
        return edges;
    }


    public boolean[] customEdgeChecker(Map<String, Double> cosinedMap, int size, double cosineEdge) {
        boolean[] edges = new boolean[size + 1];

        for (String key : cosinedMap.keySet()) {
            double temp = cosinedMap.get(key);
            if (temp < cosineEdge) {
                edges[Integer.parseInt(key)] = true;
            }
        }
        return edges;
    }

    private boolean isUpperCase(String s) {
        return s.equals(s.toUpperCase());
    }

}