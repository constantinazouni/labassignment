package gradeshistogram;

import java.io.File;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.data.xy.XYSeries;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * HistogramGenerator creates a XY line chart based on a set of grades.
 * The set of grades is stored in a txt file in a path of your preference.
 * @author Constantina Zouni
 */

public class HistogramGenerator {

    /**
     * Receives the filepath of the txt file as an input.
     * Reades the file.
     * Parses string into ints.
     * Stores and returns grades in an array list.     
     */
    public static ArrayList<Integer> loadGradesFromFile(String filePath) {               
        ArrayList<Integer> grades = new ArrayList<Integer>();
        try {
            File file = new File(filePath);            
            Scanner myReader = new Scanner(file);
            while (myReader.hasNextLine()) {
               grades.add(Integer.parseInt(myReader.nextLine()));               
            }          
            myReader.close();
        } catch (Exception e) {
            System.out.println("ERROR " + e.getMessage());
            System.exit(0);
        }
        return grades;
    }

    /**
    * Gets an array list with the grades as input.
    * Creates and returns an array where in every position is stored the frequency of that position    
    */
    public static int[] calculateFrequencies(ArrayList<Integer> grades) {
        int max=Collections.max(grades);
        int[] freq = new int[max + 1];
        for(int i = 0; i < grades.size(); i++) {
            freq[grades.get(i)] = freq[grades.get(i)] + 1;
        }
        return freq;
    }

    /**
     * Gets grades frequencies as an input.
     * Generates histogram chart using JFree.     
     */
    public static void generateChart(int[] freq) {
        XYSeriesCollection dataset = new XYSeriesCollection();
        XYSeries data = new XYSeries("freq");
        
        for (int i = 0; i < freq.length; i++) {
            data.add(i, freq[i]);
        }
        dataset.addSeries(data);

        boolean legend = false;
        boolean tooltips = false;
        boolean urls = false;
        JFreeChart chart = ChartFactory.createXYLineChart("Grades Histogram", "Grades", "Frequency", 
        dataset, PlotOrientation.VERTICAL, legend, tooltips, urls);
        ChartFrame frame = new ChartFrame("Histogram", chart);
        frame.pack();
        frame.setVisible(true);
    }

    /**
     * Main receives the filepath as an arguments from the user.
     * Calls the necessary functions. 
     * Produces the grades frequency histogram chart.     
     */
    public static void main(String[] args) {
        String filePath = args[0];
        ArrayList<Integer> grades = loadGradesFromFile(filePath);
        int[] freq = calculateFrequencies(grades);
        generateChart(freq);
    }
}