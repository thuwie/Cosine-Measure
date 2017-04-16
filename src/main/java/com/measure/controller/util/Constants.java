package main.java.com.measure.controller.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Class which contains all kind of a static objects and strings
 */

public class Constants {

    public static String delimiter = " .!,?;:_()[]$-@~/*#&\"";

    public static String END_OF_PARAGRAPH="EndOfParagraph";


    public static List<String> ignoredWords = new ArrayList<>(
            Arrays.asList(
            "в", "но","им","их","и","бы","то","с","они",
            "им","это","его","свое","на","не","что","как",
            "за","так","из"));
}
