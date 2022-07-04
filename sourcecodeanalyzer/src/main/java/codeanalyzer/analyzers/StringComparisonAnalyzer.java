package codeanalyzer.analyzers;

import java.io.IOException;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import codeanalyzer.readers.*;
import codeanalyzer.metrics.*;

/**
 * Takes a Java source code file and calculates the metrics: loc,
 * nom and noc and reads the file as a String
 * @author agkortzis
 * @author constantinazouni
 * 
 */
public class StringComparisonAnalyzer implements DataAnalyzer {
	/**
	 * Calculates the metrics loc, noc, nom
	 * @param filepath, the path of the input file
     * @param sourceFileLocation, web or local
	 * @return a Map that contains the name and the value of
	 * each metric
	 * @throws IOException
	 */
	@Override
	public Map<String, Integer> calculateMetrics(String filepath, String sourceFileLocation) throws IOException {
		FileReaderFactory reader_factory = new FileReaderFactory();
		SourceFileReader reader = reader_factory.initializeSourceFileReader(sourceFileLocation);
		Metric loc = new LOC();
		Metric noc = new NOC();
		Metric nom = new NOM();
		Map<String, Integer> metrics = new HashMap<String, Integer>();
		List<String> codeList = reader.readFileIntoList(filepath);
		metrics.put("LOC", loc.calculateWithStrcomp(codeList));
		metrics.put("NOC", noc.calculateWithStrcomp(codeList));
		metrics.put("NOM", nom.calculateWithStrcomp(codeList));
		return metrics;
	}

}