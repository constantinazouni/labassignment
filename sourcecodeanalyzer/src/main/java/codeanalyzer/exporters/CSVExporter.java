package codeanalyzer.exporters;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

/**
 * Exports the metrics into a CSV file
 * @author agkortzis, constantinazouni
 * 
 */
public class CSVExporter implements Exporter {
	/**
	 * Creates a CSV file with the result of the metrics.
	 * The first row contains the names of each metric and the second
	 * each value
     * @param outputFilepath, the path of the output file
	 * @param metrics, the metrics
	 */
  	public void write(String outputFilepath, Map<String, Integer> metrics) {
    	File outputFile = new File(outputFilepath + ".csv");
		StringBuilder metricsNames = new StringBuilder();
		StringBuilder metricsValues = new StringBuilder();
		
		for (Map.Entry<String, Integer> entry : metrics.entrySet()) {
			metricsNames.append(entry.getKey() + ",");
			metricsValues.append(entry.getValue() + ",");
		}
		
		try {
			FileWriter writer = new FileWriter(outputFile);
			writer.append(metricsNames + "\n");
			writer.append(metricsValues + "\n");
			writer.close();
			System.out.println("Metrics saved in " + outputFile.getAbsolutePath());
		} catch (IOException e) {
			e.printStackTrace();
    }
  }

}