package main.java.com.measure.controller.data;

import java.util.*;

/**
 * Class contains paragraphs maps for data transfer
 */
public class MapContainer {

    public static List<Map<String, Integer>> list;

    public MapContainer() {
    }

    public MapContainer(List<Map<String, Integer>> list) {
        this.list = list;
    }

    public List<Map<String, Integer>> getList() {
        return list;
    }

    public void addAllList(List<Map<String, Integer>> list) {
        list.addAll(list);
    }

    public void addToList(Map<String, Integer> map) {
        list.add(map);
    }
}
