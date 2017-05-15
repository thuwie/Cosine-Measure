package edu.measure.view.util;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.StringTokenizer;

import static edu.measure.controller.util.Constants.OUTPUT_DIRECTORY;
import static edu.measure.controller.util.Constants.changedFiles;

/**
 * Class for console output methods.
 */
public class OutputProvider {
    public void printIntegerMap(Map<String, Integer> stringIntegerMap) {
        for (String key : stringIntegerMap.keySet()) {
            System.out.println(key + " " + stringIntegerMap.get(key));
        }
    }

    public void printDoubleMap(Map<String, Double> stringDoubleMap) {
        for (String key : stringDoubleMap.keySet()) {
            System.out.println(key + " " + stringDoubleMap.get(key));
        }
    }

    public void printTokenizer(StringTokenizer tokenizedText) {
        while (tokenizedText.hasMoreTokens()) {
            System.out.println(tokenizedText.nextToken());
        }
    }

    public void printDoubleArray(double[][] arrayToPrint) {
        for (int i = 0; i < arrayToPrint.length; i++) {
            for (int j = 0; j < arrayToPrint.length; j++) {
                System.out.format("%.3f ", arrayToPrint[i][j]);
            }
            System.out.println("");
        }
    }

    public void printBooleanArray(boolean[] array) {
        for (int i = 1; i < array.length; i++) {
            System.out.println("Index: " + i + " Value: " + array[i] + " ");
        }
    }

    public void printBooleanArrayToFile(boolean[] array, String name) {
        try {
            PrintWriter expertWriter = new PrintWriter(OUTPUT_DIRECTORY+name);
            for (int i = 1; i < array.length; i++) {
                expertWriter.write("" + array[i] + " \n");
            }
            changedFiles.add(name);
            expertWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void printDoubleArrayToFile(double[][] arrayToPrint, String name) {
        try {
            PrintWriter writer = new PrintWriter(OUTPUT_DIRECTORY+name);
            for (int i = 0; i < arrayToPrint.length; i++) {
                for (int j = 0; j < arrayToPrint.length; j++) {
                    writer.format("%.6f ", arrayToPrint[i][j]);
                }
                writer.println("");
            }
            changedFiles.add(name);
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
/*TODO APACHE COMMANDS STRING UTIL*/