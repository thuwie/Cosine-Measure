package edu.measure.view;


import edu.measure.controller.util.IgnorListFiller;
import edu.measure.controller.util.SemantWordsFiller;

import java.io.FileNotFoundException;

public class CosineMeasureRunner {
    public static void main(String[] args) {
        IgnorListFiller.listFillment();
        //SemantWordsFiller.semantWordsFill();
        try {
            CosineMeasure.run();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
