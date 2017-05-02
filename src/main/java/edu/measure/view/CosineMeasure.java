package edu.measure.view;


import edu.measure.controller.TextReader;
import edu.measure.controller.cosine.MeasureCalculator;
import edu.measure.controller.cosine.RecallPrecisionCalculator;
import edu.measure.controller.cosine.delimeters.DelimiterCommandMap;
import edu.measure.controller.util.Constants;
import edu.measure.controller.util.DataMapsControl;
import edu.measure.view.util.ViewPrinter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

import static edu.measure.controller.util.Constants.*;


public class CosineMeasure {

    public static void run() {
        File dir = new File(OUTPUT_DIRECTORY);
        dir.mkdir();
        Map<String, Double> resultMap = new LinkedHashMap<>();
        StringTokenizer textFromFile;
        Double result;
        PrintWriter keyWriter = null;
        PrintWriter valueWriter = null;
        try {
            keyWriter = new PrintWriter(OUTPUT_DIRECTORY + COSINE_KEYS_FILENAME);
            valueWriter = new PrintWriter(OUTPUT_DIRECTORY + COSINE_VALUES_FILENAME);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        TextReader textReader = new TextReader();
        ViewPrinter viewPrinter = new ViewPrinter();
        MeasureCalculator measureCalculator = new MeasureCalculator();
        DataMapsControl dataMapsControl = new DataMapsControl();
        Scanner input = new Scanner(System.in);

        System.out.println("Available files: germansubs, uboat, chap7, chap8\nPrint filename: ");
        Constants.staticTextFromFileForStoraging = textReader.returnStringTokenFromFile("sourceFiles/" + input.nextLine());
        System.out.println("Available modes:");

        for (String key : new DelimiterCommandMap().getCommands()) {
            System.out.println(" *   \"" + key + "\"");
        }

        System.out.println("Print command: ");
        String command = input.nextLine();
        textFromFile = Constants.staticTextFromFileForStoraging;

        List<Map<String, Integer>> list = dataMapsControl.mapConfig(textFromFile);

        for (int i = 0; i < list.size() - 1; i++) {
            String filler = "" + (i + 1);
            result = measureCalculator.mergeMaps(list.get(i), list.get(i + 1));
            resultMap.put(filler, result);
            valueWriter.println(result);
        }
        finalMap = resultMap;
        viewPrinter.printDoubleMap(resultMap);
        /*MATRIX CALCULATION
        double[][] finalMatrix = new MeasureMatrixCalculator().matrixCalculator(list);*/
        double resulted = new RecallPrecisionCalculator().cosineEdgeComparator(list, finalMap, command);

        System.out.format("Best edge: %.3f%n", resulted);
        System.out.println("Files successfully updated! " +
                "\nCheck " +
                "\n *   \"" + COSINE_VALUES_FILENAME + "\"" +
                "\n *   \"" + CUSTOM_DIVISION_FILENAME + "\"" +
                "\n *   \"" + EXPERT_DIVISION_FILENAME + "\"" +
                "\nClosing project...");
        keyWriter.close();
        valueWriter.close();
    }

}
