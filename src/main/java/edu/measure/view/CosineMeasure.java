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
        String command;
        PrintWriter keyWriter = new PrintWriter("keys.txt");
        PrintWriter valueWriter = new PrintWriter("values.txt");

        TextReader textReader = new TextReader();
        ViewPrinter viewPrinter = new ViewPrinter();
        MeasureCalculator measureCalculator = new MeasureCalculator();
        DataMapsControl dataMapsControl = new DataMapsControl();
        Scanner input = new Scanner(System.in);
        System.out.println("Choose text: \n|full\n|parhs");
        command = input.nextLine();

        if ("full".equalsIgnoreCase(command))
        {
            Constants.staticTextFromFileForStoraging = textReader.returnStringTokenFromFile("fulltext.txt");
        }
        else if("parhs".equalsIgnoreCase(command))
        {
            Constants.staticTextFromFileForStoraging = textReader.returnStringTokenFromFile("germanSubsMainText");
        }
        else{
            System.out.println("Error. Closing project");
        }

        textFromFile = Constants.staticTextFromFileForStoraging;

        List<Map<String, Integer>> list = dataMapsControl.mapConfig(textFromFile);
        int tp=0,fn=0;

        for (int i = 0; i < list.size()-1; i++) {
            String filler=""+i+"-"+(i+1);
            result = measureCalculator.mergeMaps(list.get(i), list.get(i + 1));
            if (result>0.18){tp++;}
            else{fn++;}
            finalMap.put(filler,result);
            keyWriter.println(filler);
            valueWriter.println(result);

        }
        viewPrinter.printDoubleMap(finalMap);
        //new ChartPrinter().createGraph(finalMap);
        double[][] finalMatrix = new MeasureMatrixCalculator().matrixCalculator(list);
        viewPrinter.printDoubleArray(finalMatrix);
        System.out.println("True positive"+tp+" False negative"+fn);
        keyWriter.close();
        valueWriter.close();
    }

}
