package edu.measure.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Contains logic for arrays fillment with edges
 */
public class ParahsEdgeCounter {
    public boolean[] expertEdgeChecker(List<Map<String, Integer>> list, int size) {
        boolean[] edges = new boolean[size];

        for (Map<String, Integer> map : list) {
            List<String> listParah = new ArrayList<String>(map.keySet());
            if (isUpperCase(listParah.get(1))) {
                edges[Integer.parseInt(listParah.get(0))] = true;
            }
        }

        return edges;

    }

    public boolean isUpperCase(String s) {
        return s.equals(s.toUpperCase());
    }

}