package edu.measure.controller.cosine;

import edu.measure.controller.cosine.delimeters.DelimiterCommandMap;
import edu.measure.controller.util.DivisionMarker;
import edu.measure.view.util.OutputProvider;

import java.util.List;
import java.util.Map;

import static edu.measure.controller.util.Constants.*;

/**
 * logic of recall-precision-f1 calculations
 */
public class RecallPrecisionCalculator {
    private static final DivisionMarker divisionMarker = new DivisionMarker();

    public double cosineEdgeComparator(List<Map<String, Integer>> list, Map<String, Double> calculatedMap, String userCommand) {
        DelimiterCommandMap commandMap = new DelimiterCommandMap();
        DelimiterCommand delimiterCommand;
        double compareResult, bestResult = 0;
        double bestEdge = 0;
        boolean[] expertEdges = divisionMarker.expertEdgeChecker(list, list.size());
        boolean[] customEdges;
        Map<String, DelimiterCommand> delimiterCommandMap = commandMap.getDelimiterCommandMap();
        delimiterCommand = delimiterCommandMap.get(userCommand.toLowerCase());

        if (delimiterCommand != null) {
            if (EXPERT_EDGES_OPTION.equalsIgnoreCase(userCommand)) {
                bestEdge = delimiterCommand.executeCommand(expertEdges, null);
            } else {
                for (double edge = 0.001; edge < 1; edge = edge + 0.001) {
                    customEdges = divisionMarker.customEdgeChecker(calculatedMap, calculatedMap.size(), edge);
                    compareResult = delimiterCommand.executeCommand(expertEdges, customEdges);
                    if (compareResult > bestResult) {
                        bestEdge = edge;
                        bestResult = compareResult;}
                    System.out.format("Edge: %.3f | %s: %.3f%n", edge,userCommand,compareResult);
                }
            }
        } else {
            System.out.println("Wrong command!");
        }

        customEdges = divisionMarker.customEdgeChecker(calculatedMap, calculatedMap.size(), bestEdge);
        new OutputProvider().printBooleanArrayToFile(customEdges, CUSTOM_DIVISION_FILENAME);
        new OutputProvider().printBooleanArrayToFile(expertEdges, EXPERT_DIVISION_FILENAME);


        return bestEdge;
    }

}
