package edu.measure.controller.util;


import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import static edu.measure.controller.util.Constants.END_OF_PARAGRAPH;


/**
 * Contains text refraction logic
 */
public class DataMapsControl {

    public List<Map<String, Integer>> mapConfig(StringTokenizer textFromFile) {
        StringTokenizer summonedParagraphToken;
        String summonedParagraphString;
        TokenizerControl tokenizerControl = new TokenizerControl();
        List<Map<String, Integer>> listedList = new LinkedList<>();
        while (textFromFile.hasMoreTokens()) {
            summonedParagraphString = tokenToString(textFromFile);
            summonedParagraphToken = new StringTokenizer(summonedParagraphString);
            listedList.add(tokenizerControl.mapFromTokenizer(summonedParagraphToken));

            textFromFile = tokenizerControl.excludeFromTokenizer(textFromFile, summonedParagraphString);
        }
        return listedList;
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


