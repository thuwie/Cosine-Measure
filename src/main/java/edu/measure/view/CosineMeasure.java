package edu.measure.view;


import edu.measure.controller.*;
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
        Double result,edge=1.0;
        String command;
        PrintWriter keyWriter = new PrintWriter("keys.txt");
        PrintWriter valueWriter = new PrintWriter("values.txt");
        ParahsEdgeCounter parahsEdgeCounter = new ParahsEdgeCounter();
        TextReader textReader = new TextReader();
        ViewPrinter viewPrinter = new ViewPrinter();
        MeasureCalculator measureCalculator = new MeasureCalculator();
        DataMapsControl dataMapsControl = new DataMapsControl();
        Scanner input = new Scanner(System.in);
        System.out.println("Choose text: \n|full\n|parhs");
        command = input.nextLine();
        System.out.println("Choose edge for recall-precision: ");
        edge=input.nextDouble();

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
            if (result>edge){tp++;}
            else{fn++;}
            finalMap.put(filler,result);
            keyWriter.println(filler);
            valueWriter.println(result);

        }
        viewPrinter.printDoubleMap(finalMap);
        //new ChartPrinter().createGraph(finalMap);
        double[][] finalMatrix = new MeasureMatrixCalculator().matrixCalculator(list);
        viewPrinter.printDoubleArray(finalMatrix);
        System.out.println("True positive: "+tp+" False negative: "+fn+" Based on "+edge+" edge");
        keyWriter.close();
        valueWriter.close();
        System.out.println("____________");
        System.out.println(measureCalculator.mergeMaps(list.get(1),list.get(3)));
        System.out.println("______");

        System.out.println(measureCalculator.mergeMaps(list.get(3),list.get(1)));
        boolean[] massiv = parahsEdgeCounter.expertEdgeChecker(list,list.size());
        viewPrinter.printBooleanArray(massiv);
    }

}
