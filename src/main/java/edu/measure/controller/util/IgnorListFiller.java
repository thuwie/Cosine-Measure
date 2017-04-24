package edu.measure.controller.util;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


/**
 * Ignor originalListOfParagraphs fillment
 */
public class IgnorListFiller {
    public static void listFillment(){
        String readedText;
        try {
            BufferedReader input;
            input = new BufferedReader(new FileReader("IgnoreList"));
            readedText = input.readLine();
            while (readedText != null) {
                Constants.ignoredWords.add(readedText);
                readedText = input.readLine();

            }
            input.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
