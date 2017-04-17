package main.java.edu.measure.controller.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

import static main.java.edu.measure.controller.util.Constants.delimiter;
import static main.java.edu.measure.controller.util.Constants.semantWords;

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
            StringTokenizer stringTokenizer = new StringTokenizer(readedText,delimiter);
            while (readedText != null) {
                while(stringTokenizer.hasMoreTokens()){
                semantWords.put(stringTokenizer.nextToken(),stringTokenizer.nextToken());}
                readedText = input.readLine();

            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
