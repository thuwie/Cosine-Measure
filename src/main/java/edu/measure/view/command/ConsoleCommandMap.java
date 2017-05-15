package edu.measure.view.command;


import edu.measure.view.ConsoleCommand;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import static edu.measure.controller.util.Constants.COSINE_CALCULATION_OPTION;
import static edu.measure.controller.util.Constants.EXIT_OPTION;
import static edu.measure.controller.util.Constants.MATRIX_CALCULATION_OPTION;

public class ConsoleCommandMap {
    private Map<String, ConsoleCommand> consoleCommandMap;

    public ConsoleCommandMap() {
        final ConsoleExecutors consoleExecutors = new ConsoleExecutors();
        consoleCommandMap = new LinkedHashMap<>();
        consoleCommandMap.put(COSINE_CALCULATION_OPTION, consoleExecutors::cosineMeasureOption);
        consoleCommandMap.put(MATRIX_CALCULATION_OPTION, consoleExecutors::distMatrixOption);
        consoleCommandMap.put(EXIT_OPTION, () -> {
            consoleExecutors.onFinish();
            System.exit(0);
        });
    }

    public Map<String, ConsoleCommand> getConsoleCommandMap() {
        return consoleCommandMap;
    }
    public Set<String> getCommands() {
        return consoleCommandMap.keySet();
    }
}
