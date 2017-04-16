package main.java.com.measure.controller;


import main.java.com.measure.controller.data.MapContainer;
import main.java.com.measure.controller.util.TokenizerControl;

import java.util.*;

import static main.java.com.measure.controller.util.Constants.END_OF_PARAGRAPH;


/**
 * Contains text refraction logic
 */
public class DataMapsControl {

    public void mapConfig(StringTokenizer textFromFile) {
        StringTokenizer summonedParagraphToken;
        String summonedParagraphString = "";
        TokenizerControl tokenizerControl = new TokenizerControl();
        List<Map<String, Integer>> listedList = new LinkedList<>();
        while (textFromFile.hasMoreTokens()) {
            summonedParagraphString=tokenToString(textFromFile);
            summonedParagraphToken = new StringTokenizer(summonedParagraphString);
            listedList.add(tokenizerControl.mapFromTokenizer(summonedParagraphToken));

            textFromFile = tokenizerControl.excludeFromTokenizer(textFromFile, summonedParagraphString);
        }
        MapContainer mapContainer = new MapContainer(listedList);
    }

    private String tokenToString(StringTokenizer stringTokenizer) {
        String summonedParagraphString = "";
        while (stringTokenizer.hasMoreTokens()) {
            String temp = stringTokenizer.nextToken();
            if (temp.equals(END_OF_PARAGRAPH)) break;
            summonedParagraphString += temp + " ";
        }
        return summonedParagraphString;
    }
}


