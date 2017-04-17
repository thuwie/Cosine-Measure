package main.java.edu.measure.controller;


import main.java.edu.measure.controller.data.MapContainer;
import main.java.edu.measure.controller.util.TokenizerControl;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import static main.java.edu.measure.controller.util.Constants.END_OF_PARAGRAPH;
import static main.java.edu.measure.controller.util.Constants.semantWords;


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
            summonedParagraphString = tokenToString(textFromFile);
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
            temp=wordReplacer(temp);
            summonedParagraphString += temp + " ";
        }
        return summonedParagraphString;
    }

    private String wordReplacer(String string) {
        for (Map.Entry s : semantWords.entrySet()) {
            if (string.contains(s.getKey().toString())) {
                string = s.getValue().toString();
            }

        }
        return string;
    }
}


