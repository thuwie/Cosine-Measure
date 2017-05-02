package edu.measure.controller.util;

import java.util.Map;
import java.util.StringTokenizer;

/**
 * Class which contains all kind of a static objects and strings
 */

public class Constants {

    public static Map<String,Double> finalMap;
    public static String delimiter = " .!,?;:_()[]$=@~/*#&\"";

    public static final String FONE_OPTION = "fone";
    public static final String RECALL_OPTION = "recall";
    public static final String PRECISION_OPTION = "precision";
    public static final String ACCURACY_OPTION = "accuracy";
    public static final String EXPERT_EDGES_OPTION = "expert";

    public static final String COSINE_KEYS_FILENAME="cosineMeasureKeys.txt";
    public static final String COSINE_VALUES_FILENAME="cosineMeasureValues.txt";
    public static final String EXPERT_DIVISION_FILENAME="expertEdges.txt";
    public static final String CUSTOM_DIVISION_FILENAME="customEdges.txt";
    public static final String OUTPUT_DIRECTORY="outputFiles/";

    public static final String END_OF_PARAGRAPH="EndOfParagraph";

    public static StringTokenizer staticTextFromFileForStoraging = new StringTokenizer("");
}
