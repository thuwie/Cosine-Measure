package edu.measure.controller.cosine;

/**
 * interface for command-map pattern using for custom edges separations
 */
public interface DelimiterCommand {
    double executeCommand(boolean[] booleans1, boolean[] booleans2);
}
