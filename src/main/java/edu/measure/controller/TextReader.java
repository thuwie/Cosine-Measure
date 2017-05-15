package edu.measure.controller;


import edu.measure.controller.util.Constants;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

import static edu.measure.controller.util.Constants.END_OF_PARAGRAPH;


/**
 * Class serves for text reading
 */

public class TextReader {
    public StringTokenizer returnStringTokenFromFile(String filename) {
        String readText;
        String finalText = "";
        BufferedReader input;
        try {
             input = new BufferedReader(new FileReader(filename));
            readText = input.readLine();
            while (readText != null) {
                finalText += readNextLine(readText);
                readText = input.readLine();
            }
            input.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return new StringTokenizer(finalText, Constants.delimiter);

    }

    private String readNextLine(String string) {
        return (string + " " + END_OF_PARAGRAPH + " ");
    }

}
