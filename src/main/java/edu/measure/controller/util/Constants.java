package edu.measure.controller.util;

import java.util.*;

/**
 * Class which contains all kind of a static objects and strings
 */

public class Constants {

    public static Map<String, Double> finalMap;
    public static List<Map<String, Integer>> listOfCosinusedMaps;
    public static Set<String> changedFiles =new HashSet<>();
    public static Scanner input = new Scanner(System.in);

    public static String delimiter = " .!,?;:_()[]$=@~/*#&\"";
    public static String filename;

    /***COSINE MEASURE OPTIONS BLOCK*/
    public static final String FONE_OPTION = "fone";
    public static final String RECALL_OPTION = "recall";
    public static final String PRECISION_OPTION = "precision";
    public static final String ACCURACY_OPTION = "accuracy";
    public static final String EXPERT_EDGES_OPTION = "expert";
    /***END OF COSINE MEASURE OPTIONS BLOCK*/

    /***MAIN MENU OPTIONS BLOCK*/
    public static final String COSINE_CALCULATION_OPTION = "cosine";
    public static final String MATRIX_CALCULATION_OPTION = "matrix";
    public static final String EXIT_OPTION = "exit";
    /***END OF MAIN MENU OPTIONS BLOCK*/


    /***START OF FILES NAMES BLOCK*/
    public static final String COSINE_KEYS_FILENAME = "cosineMeasureKeys.txt";
    public static final String COSINE_VALUES_FILENAME = "cosineMeasureValues.txt";
    public static final String EXPERT_DIVISION_FILENAME = "expertEdges.txt";
    public static final String CUSTOM_DIVISION_FILENAME = "customEdges.txt";
    public static final String COSINE_MEASURE_MATRIX_FILENAME = "matrix.txt";

    public static final String INPUT_DIRECTORY = "sourceFiles/";
    public static final String OUTPUT_DIRECTORY = "outputFiles/";
    /***END OF FILES NAMES BLOCK*/

    public static final String END_OF_PARAGRAPH = "EndOfParagraph";

    public static StringTokenizer staticTextFromFileForStoraging = new StringTokenizer("");
}
