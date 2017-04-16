package main.java.com.measure.controller;



import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import static main.java.com.measure.controller.util.Constants.ignoredWords;
import static main.java.com.measure.controller.util.TokenizerControl.tokenizerToString;

/**
 * Contains text refraction logic
 */
public class DataFill {
    private Map<String, Integer> mapFromTokenizer(StringTokenizer tokenizer) {
        Map<String, Integer> resultMap = new HashMap<>();
        while (tokenizer.hasMoreTokens()) {
            String word = tokenizer.nextToken();
            if (!ignoredWords.contains(word)) {
                if (resultMap.containsKey(word)) {
                    resultMap.put(word, resultMap.get(word) + 1);
                } else resultMap.put(word, 1);
            }
        }
        return resultMap;
    }
    public void mapConfig(StringTokenizer tokenizer){

    }
    public StringTokenizer excludeFromTokenizer(StringTokenizer stringTokenizer,String sub)
    {
        String text = tokenizerToString(stringTokenizer);
        text.substring(0, sub.length()-1);
        return new StringTokenizer(text);
    }

}
