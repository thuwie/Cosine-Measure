package main.java.edu.measure.view;


import main.java.edu.measure.controller.util.IgnorListFiller;
import main.java.edu.measure.controller.util.SemantWordsFiller;


public class CosineMeasureRunner {
    public static void main(String[] args) {
        IgnorListFiller.listFillment();
        SemantWordsFiller.semantWordsFill();
        CosineMeasure.run();
    }
}
