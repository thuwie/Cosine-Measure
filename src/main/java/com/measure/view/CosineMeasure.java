package main.java.com.measure.view;


import main.java.com.measure.controller.DataMapsControl;
import main.java.com.measure.controller.TextReader;
import main.java.com.measure.controller.data.MapContainer;
import main.java.com.measure.view.util.ViewPrinter;

import java.util.*;

import static main.java.com.measure.controller.util.Constants.staticTextFromFileForStoraging;


public class CosineMeasure {

    public static void run() {
        StringTokenizer textFromFile;

        MapContainer mapContainer = new MapContainer();
        TextReader textReader = new TextReader();
        ViewPrinter viewPrinter = new ViewPrinter();


        DataMapsControl dataMapsControl = new DataMapsControl();
        staticTextFromFileForStoraging = textReader.returnStringTokenFromFile("germanSubsChunkText");
        textFromFile = staticTextFromFileForStoraging;

        dataMapsControl.mapConfig(textFromFile);
        for(Map<String, Integer>  map : mapContainer.getList())
        {
            viewPrinter.printMap(map);
        }
    }
}
