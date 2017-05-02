package edu.measure.controller.data;


import java.util.List;
import java.util.Map;

/**
 * Class contains paragraphs maps for data transfer
 */
public class MapContainer {

    public static List<Map<String, Integer>> originalListOfParagraphs;

    private MapContainer() {
        try {
            throw new IllegalAccessException("Chooo???");
        } catch (IllegalAccessException e) {
            System.out.println(e.getMessage());
        }
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
