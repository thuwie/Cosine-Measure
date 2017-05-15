package edu.measure.view;


import edu.measure.view.command.ConsoleCommandMap;
import edu.measure.view.command.ConsoleExecutors;

import java.util.Map;

import static edu.measure.controller.util.Constants.input;

public class CosineMeasure {
    public static void run() {
        ConsoleCommandMap commandMap = new ConsoleCommandMap();
        ConsoleCommand delimiterCommand;
        String userCommand;
        new ConsoleExecutors().onStart();
        while (true) {
            Map<String, ConsoleCommand> consoleCommandMap = commandMap.getConsoleCommandMap();
            System.out.println("Available actions: ");
            for (String command : consoleCommandMap.keySet()) {
                System.out.println(" *   \"" + command + "\"");
            }
            userCommand = input.nextLine();
            delimiterCommand = consoleCommandMap.get(userCommand.toLowerCase());
            if (delimiterCommand != null) {
                delimiterCommand.executeCommand();
            }
        }
    }
}
