package edu.measure.view.command;


import edu.measure.controller.MeasureMatrixCalculator;
import edu.measure.controller.TextReader;
import edu.measure.controller.cosine.MeasureCalculator;
import edu.measure.controller.cosine.RecallPrecisionCalculator;
import edu.measure.controller.cosine.delimeters.DelimiterCommandMap;
import edu.measure.controller.util.Constants;
import edu.measure.controller.util.DataMapsControl;
import edu.measure.view.util.OutputProvider;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.Map;

import static edu.measure.controller.util.Constants.*;

public class ConsoleExecutors {
    public void onStart() {
        TextReader textReader = new TextReader();
        DataMapsControl dataMapsControl = new DataMapsControl();

        File dir = new File(OUTPUT_DIRECTORY);
        dir.mkdir();

        System.out.println("Available files:");
        File[] files = new File(INPUT_DIRECTORY).listFiles();
        for (File file : files) {
            if (file.isFile()) {
                System.out.println("* " + file.getName());
            }
        }
        System.out.println("Print filename: ");
        filename = input.nextLine();
        Constants.staticTextFromFileForStoraging = textReader.returnStringTokenFromFile(INPUT_DIRECTORY + filename);
        listOfCosinusedMaps = dataMapsControl.mapConfig(staticTextFromFileForStoraging);
    }
    public void onFinish(){
        System.out.println("Files updated: ");
        for(String key : changedFiles)
        {
            System.out.println("\"" + key + "\"");
        }
    }

    public void cosineMeasureOption() {
        if (finalMap == null) {
            cosineMeasureUtil();
        }
        System.out.println("Available modes:");
        for (String key : new DelimiterCommandMap().getCommands()) {
            System.out.println(" *   \"" + key + "\"");
        }
        System.out.println("Print command: ");
        String command = input.nextLine();
        double resulted = new RecallPrecisionCalculator().cosineEdgeComparator(listOfCosinusedMaps, finalMap, command);
        System.out.format("Best edge: %.3f%n", resulted);
    }

    public void distMatrixOption() {
        OutputProvider outputProvider = new OutputProvider();
        double[][] finalMatrix = new MeasureMatrixCalculator().matrixCalculator(listOfCosinusedMaps);
        outputProvider.printDoubleArrayToFile(finalMatrix, filename + COSINE_MEASURE_MATRIX_FILENAME);
        System.out.println("Matrix successfully created.");
    }

    private void cosineMeasureUtil() {
        Map<String, Double> resultMap = new LinkedHashMap<>();
        Double result;

        MeasureCalculator measureCalculator = new MeasureCalculator();

        try (PrintWriter keyWriter = new PrintWriter(OUTPUT_DIRECTORY + COSINE_KEYS_FILENAME);
             PrintWriter valueWriter = new PrintWriter(OUTPUT_DIRECTORY + COSINE_VALUES_FILENAME);) {

            for (int i = 0; i < listOfCosinusedMaps.size() - 1; i++) {
                String filler = "" + (i + 1);
                result = measureCalculator.mergeMaps(listOfCosinusedMaps.get(i), listOfCosinusedMaps.get(i + 1));
                resultMap.put(filler, result);
                keyWriter.println(filler);
                valueWriter.println(result);
            }
            finalMap = resultMap;
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
