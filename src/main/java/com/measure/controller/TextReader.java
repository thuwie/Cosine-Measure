package main.java.com.measure.controller;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

import main.java.com.measure.controller.util.Constants;

import static main.java.com.measure.controller.util.Constants.END_OF_PARAGRAPH;


/**
 * Class serves for text reading
 */

public class TextReader {
    public StringTokenizer returnStringTokenFromFile(String filename) {
        String readedText;
        String finalText = "";
        try {
            BufferedReader input;
            input = new BufferedReader(new FileReader(filename));
            readedText = input.readLine();
            while (readedText != null) {
                finalText += readNextLine(readedText);
                readedText = input.readLine();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return new StringTokenizer(finalText, Constants.delimiter);
    }

    private String readNextLine(String string) {
        return (string + " " + END_OF_PARAGRAPH + " ");
    }

}
