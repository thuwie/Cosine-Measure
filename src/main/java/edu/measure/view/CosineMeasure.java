package edu.measure.view;




import edu.measure.controller.DataMapsControl;
import edu.measure.controller.MeasureCalculator;
import edu.measure.controller.TextReader;
import edu.measure.controller.data.MapContainer;
import edu.measure.view.util.ViewPrinter;
import edu.measure.controller.util.Constants;

import java.util.*;


public class CosineMeasure {

    public static void run() {
        StringTokenizer textFromFile;

        MapContainer mapContainer = new MapContainer();
        TextReader textReader = new TextReader();
        ViewPrinter viewPrinter = new ViewPrinter();
        MeasureCalculator measureCalculator = new MeasureCalculator();
        DataMapsControl dataMapsControl = new DataMapsControl();

        Constants.staticTextFromFileForStoraging = textReader.returnStringTokenFromFile("germanSubsChunkText");
        textFromFile = Constants.staticTextFromFileForStoraging;

        dataMapsControl.mapConfig(textFromFile);
        for(Map<String, Integer>  map : mapContainer.getList())
        {
            viewPrinter.printMap(map);
        }

        System.out.println("______________________");
        measureCalculator.mergeMaps(mapContainer.getList().get(0),mapContainer.getList().get(1));
    }
}
