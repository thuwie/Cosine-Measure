package main.java.com.measure.controller.util;

import java.util.StringTokenizer;

/**
 * Class contains method for StringTokenizer usage
 */
public class TokenizerControl {
    public static String tokenizerToString(StringTokenizer stringTokenizer)
    {
        String resultString="";
        while(stringTokenizer.hasMoreTokens())
        {
            resultString+=stringTokenizer.nextToken()+" ";
        }
        return resultString;
    }
}
