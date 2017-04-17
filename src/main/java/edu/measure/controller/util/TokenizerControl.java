package main.java.edu.measure.controller.util;

import java.util.*;

import static main.java.edu.measure.controller.util.Constants.ignoredWords;

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
            if (!ignoredWords.contains(word)) {
                if (resultMap.containsKey(word)) {
                    resultMap.put(word, resultMap.get(word) + 1);
                } else resultMap.put(word, 1);
            }
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
