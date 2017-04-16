package main.java.com.measure.view;


import main.java.com.measure.controller.DataFill;
import main.java.com.measure.controller.TextReader;

import java.util.StringTokenizer;

import static main.java.com.measure.controller.util.Constants.END_OF_PARAGRAPH;

public class CosineMeasureRunner {
    public static void main(String[] args) {
        TextReader textReader = new TextReader();
        DataFill dataFill = new DataFill();
        String test = "";
        StringTokenizer stringTokenizer = textReader.returnStringTokenFromFile("germanSubsChunkText");
         while (stringTokenizer.hasMoreTokens()) {
            String temp = stringTokenizer.nextToken();
            test+=temp;
            if(temp.equals(END_OF_PARAGRAPH)) break;
         }
        StringTokenizer workTokenizer = dataFill.excludeFromTokenizer(stringTokenizer, test);

         while (workTokenizer.hasMoreTokens()) {
             System.out.println(workTokenizer.nextToken());
         }
        new DataFill().mapConfig(stringTokenizer);

    }
}
