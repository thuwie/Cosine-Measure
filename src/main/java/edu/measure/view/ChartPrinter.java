package edu.measure.view;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import java.awt.*;
import java.util.Map;
/**
 * Class for chart creation
 */
class ChartPrinter {
    void createGraph(Map<String,Double> gotMap)
    {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        for(String key : gotMap.keySet())
        {
            dataset.addValue(gotMap.get(key),"1",key);
        }
        JFreeChart objChart = ChartFactory.createBarChart(
                "Chart",     //Chart title
                "",     //Domain axis label
                "Cosine Measure",         //Range axis label
                dataset,         //Chart Data
                PlotOrientation.VERTICAL, // orientation
                false,             // include legend?
                false,             // include tooltips?
                false             // include URLs?
        );


        ChartFrame frame = new ChartFrame("Demo", objChart);
        frame.pack();
        frame.setVisible(true);
    }
}
