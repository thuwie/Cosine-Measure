package main.java.edu.measure.view;


import main.java.edu.measure.controller.DataMapsControl;
import main.java.edu.measure.controller.MeasureCalculator;
import main.java.edu.measure.controller.TextReader;
import main.java.edu.measure.controller.data.MapContainer;
import main.java.edu.measure.view.util.ViewPrinter;

import java.util.*;

import static main.java.edu.measure.controller.util.Constants.staticTextFromFileForStoraging;


public class CosineMeasure {

    public static void run() {
        StringTokenizer textFromFile;

        MapContainer mapContainer = new MapContainer();
        TextReader textReader = new TextReader();
        ViewPrinter viewPrinter = new ViewPrinter();
        MeasureCalculator measureCalculator = new MeasureCalculator();


        DataMapsControl dataMapsControl = new DataMapsControl();
        staticTextFromFileForStoraging = textReader.returnStringTokenFromFile("germanSubsChunkText");
        textFromFile = staticTextFromFileForStoraging;

        dataMapsControl.mapConfig(textFromFile);
        for(Map<String, Integer>  map : mapContainer.getList())
        {
            viewPrinter.printMap(map);
        }

        System.out.println("______________________");
        measureCalculator.mergeMaps(mapContainer.getList().get(0),mapContainer.getList().get(1));
    }
}
