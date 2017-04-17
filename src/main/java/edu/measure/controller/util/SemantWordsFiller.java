package edu.measure.controller.util;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 * Cognate map fillment
 */
public class SemantWordsFiller {
    public static void semantWordsFill(){
        String readedText;
        try {
            BufferedReader input;
            input = new BufferedReader(new FileReader("ModList"));
            readedText = input.readLine();
            StringTokenizer stringTokenizer = new StringTokenizer(readedText, Constants.delimiter);
            while (readedText != null) {
                while(stringTokenizer.hasMoreTokens()){
                Constants.semantWords.put(stringTokenizer.nextToken(),stringTokenizer.nextToken());}
                readedText = input.readLine();

            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
