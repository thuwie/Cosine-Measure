package main.java.com.measure.view.util;

import java.util.Map;
import java.util.StringTokenizer;

/**
 * Class for console output methods.
 */
public class ViewPrinter {
    private void printMap(Map<String, Integer> stringIntegerMap) {
        for(String key : stringIntegerMap.keySet())
        {
            System.out.println(key+" "+stringIntegerMap.get(key));
        }
    }

    private void printTokenizer(StringTokenizer tokenizedText) {
        while (tokenizedText.hasMoreTokens()) {
            System.out.println(tokenizedText.nextToken());
        }
    }
}
