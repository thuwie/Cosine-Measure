package main.java.com.measure.controller.util;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Class which contains all kind of a static objects and strings
 */

public class Constants {

    public static String delimiter = " .!,?;:_()[]$-@~/*#&\"";

    public static String END_OF_PARAGRAPH="EndOfParagraph";


    public static List<String> ignoredWords = new ArrayList<>();
    public static StringTokenizer staticTextFromFileForStoraging = new StringTokenizer("");
}
