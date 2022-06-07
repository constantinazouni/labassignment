package codeanalyzer.exporters;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

public class CSVExporterTest {
  private String outputFilepath = "src/test/resources/tempfile";
  private CSVExporter exporter = new CSVExporter();
  	
	@Test
	public void testWriteCsv() {
		Map<String, Integer> metrics = new HashMap<>();
		metrics.put("LOC",7);
		metrics.put("NOM",3);
		metrics.put("NOC",3);
		exporter.write(outputFilepath, metrics);
		File outputFile = new File(outputFilepath + ".csv");
		Assert.assertTrue(outputFile.exists());
		outputFile.delete();
	}
	
}