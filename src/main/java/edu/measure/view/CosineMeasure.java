package edu.measure.view;


import edu.measure.controller.DataMapsControl;
import edu.measure.controller.MeasureCalculator;
import edu.measure.controller.RecallPrecisionCalculator;
import edu.measure.controller.TextReader;
import edu.measure.controller.util.Constants;
import edu.measure.view.util.ViewPrinter;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;


public class CosineMeasure {

    public static void run() throws FileNotFoundException {
        Map<String, Double> finalMap = new LinkedHashMap<>();
        StringTokenizer textFromFile;
        Double result;
        PrintWriter keyWriter = new PrintWriter("cosineMeasureKeys.txt");
        PrintWriter valueWriter = new PrintWriter("cosineMeasureValues.txt");
        TextReader textReader = new TextReader();
        ViewPrinter viewPrinter = new ViewPrinter();
        MeasureCalculator measureCalculator = new MeasureCalculator();
        DataMapsControl dataMapsControl = new DataMapsControl();
        Scanner input = new Scanner(System.in);

        System.out.println("Available files: germansubs, uboat, chap7, chap8\nPrint filename: ");
        Constants.staticTextFromFileForStoraging = textReader.returnStringTokenFromFile(input.nextLine());
        textFromFile = Constants.staticTextFromFileForStoraging;

        List<Map<String, Integer>> list = dataMapsControl.mapConfig(textFromFile);

        for (int i = 0; i < list.size() - 1; i++) {
            String filler = "" + (i + 1);
            result = measureCalculator.mergeMaps(list.get(i), list.get(i + 1));
            finalMap.put(filler, result);
            valueWriter.println(result);
        }

        viewPrinter.printDoubleMap(finalMap);
        /*MATRIX CALCULATION
        double[][] finalMatrix = new MeasureMatrixCalculator().matrixCalculator(list);*/
        String resulted = new RecallPrecisionCalculator().cosineEdgeComparator(list, finalMap);
        System.out.println(resulted);

        keyWriter.close();
        valueWriter.close();
    }

}
