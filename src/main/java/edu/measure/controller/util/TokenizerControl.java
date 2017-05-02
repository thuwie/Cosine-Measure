package edu.measure.controller.util;


import java.util.LinkedHashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * Class contains method for StringTokenizer usage
 */
public class TokenizerControl {
    public static String tokenizerToString(StringTokenizer stringTokenizer) {
        String resultString = "";
        while (stringTokenizer.hasMoreTokens()) {
            resultString += stringTokenizer.nextToken() + " ";
        }
        return resultString;
    }

    public Map<String, Integer> mapFromTokenizer(StringTokenizer tokenizer) {
        Map<String, Integer> resultMap = new LinkedHashMap<>();
        while (tokenizer.hasMoreTokens()) {
            String word = tokenizer.nextToken();

                if (resultMap.containsKey(word)) {
                    resultMap.put(word, resultMap.get(word) + 1);
                } else resultMap.put(word, 1);

        }
        return resultMap;
    }

    public StringTokenizer excludeFromTokenizer(StringTokenizer stringTokenizer, String sub) {
        String text = tokenizerToString(stringTokenizer);
        if (text.length() > sub.length()) {
            text.substring(0, sub.length() - 1);
        }
        return new StringTokenizer(text);
    }

}
