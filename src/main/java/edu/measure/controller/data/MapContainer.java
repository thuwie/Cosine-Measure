package edu.measure.controller.data;


import java.util.*;

/**
 * Class contains paragraphs maps for data transfer
 */
public class MapContainer {

    public static List<Map<String, Integer>> originalListOfParagraphs;

    public MapContainer() {
    }

    public MapContainer(List<Map<String, Integer>> list) {
        originalListOfParagraphs = list;
    }

    public List<Map<String, Integer>> getList() {
        return originalListOfParagraphs;
    }

    public void addAllList(List<Map<String, Integer>> list) {
        originalListOfParagraphs.addAll(list);
    }

    public void addToList(Map<String, Integer> map) {
        originalListOfParagraphs.add(map);
    }
}
