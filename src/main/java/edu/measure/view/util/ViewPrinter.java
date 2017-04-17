package edu.measure.view.util;

import java.util.Map;
import java.util.StringTokenizer;

/**
 * Class for console output methods.
 */
public class ViewPrinter {
    public void printMap(Map<String, Integer> stringIntegerMap) {
        for(String key : stringIntegerMap.keySet())
        {
            System.out.println(key+" "+stringIntegerMap.get(key));
        }
    }

    public void printTokenizer(StringTokenizer tokenizedText) {
        while (tokenizedText.hasMoreTokens()) {
            System.out.println(tokenizedText.nextToken());
        }
    }
}
/*TODO APACHE COMMANDS STRING UTIL*/