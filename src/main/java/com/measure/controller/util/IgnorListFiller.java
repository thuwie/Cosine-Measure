package main.java.com.measure.controller.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static main.java.com.measure.controller.util.Constants.ignoredWords;

/**
 * Ignor list fillment
 */
public class IgnorListFiller {
    public static void listFillment(){
        String readedText;
        try {
            BufferedReader input;
            input = new BufferedReader(new FileReader("IgnoreList"));
            readedText = input.readLine();
            while (readedText != null) {
                ignoredWords.add(readedText);
                readedText = input.readLine();

            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
