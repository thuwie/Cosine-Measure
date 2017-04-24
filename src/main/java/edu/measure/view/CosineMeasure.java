package edu.measure.view;


import edu.measure.controller.DataMapsControl;
import edu.measure.controller.MeasureCalculator;
import edu.measure.controller.MeasureMatrixCalculator;
import edu.measure.controller.TextReader;
import edu.measure.controller.data.MapContainer;
import edu.measure.controller.util.Constants;
import edu.measure.view.util.ViewPrinter;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;


public class CosineMeasure {

    public static void run() throws FileNotFoundException {
        Map<String,Double> finalMap = new LinkedHashMap<>();
        StringTokenizer textFromFile;
        Double result;
        PrintWriter keyWriter = new PrintWriter("keys.txt");
        PrintWriter valueWriter = new PrintWriter("values.txt");

        TextReader textReader = new TextReader();
        ViewPrinter viewPrinter = new ViewPrinter();
        MeasureCalculator measureCalculator = new MeasureCalculator();
        DataMapsControl dataMapsControl = new DataMapsControl();
        Scanner input = new Scanner(System.in);
        if ("full".equalsIgnoreCase(input.nextLine()))
        {
            Constants.staticTextFromFileForStoraging = textReader.returnStringTokenFromFile("fulltext.txt");
        }
        else
        {
            Constants.staticTextFromFileForStoraging = textReader.returnStringTokenFromFile("germanSubsMainText");
        }

        textFromFile = Constants.staticTextFromFileForStoraging;

        List<Map<String, Integer>> list = dataMapsControl.mapConfig(textFromFile);

        for (int i = 0; i < list.size()-1; i++) {
            String filler=""+i+"-"+(i+1);
            result = measureCalculator.mergeMaps(list.get(i), list.get(i + 1));
            finalMap.put(filler,result);
            keyWriter.println(filler);
            valueWriter.println(result);

        }
        viewPrinter.printDoubleMap(finalMap);
        //new ChartPrinter().createGraph(finalMap);
        double[][] finalMatrix = new MeasureMatrixCalculator().matrixCalculator(list);
        viewPrinter.printDoubleArray(finalMatrix);
        keyWriter.close();
        valueWriter.close();
    }

}
