package edu.measure.view;


import edu.measure.controller.util.IgnorListFiller;
import edu.measure.controller.util.SemantWordsFiller;

public class CosineMeasureRunner {
    public static void main(String[] args) {
        IgnorListFiller.listFillment();
        SemantWordsFiller.semantWordsFill();
        CosineMeasure.run();
    }
}
