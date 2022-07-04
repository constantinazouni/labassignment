package codeanalyzer.analyzers;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import codeanalyzer.readers.*;
import codeanalyzer.metrics.*;

/**
 * Takes a Java source code file and calculates the metrics: loc,
 * nom and noc for a regex file
 * @author agkortzis
 * @author constantinazouni
 * 
 */
public class RegexAnalyzer implements DataAnalyzer {
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
		String codeString = reader.readFileIntoString(filepath);
		metrics.put("LOC", loc.calculateWithRegex(codeString));
		metrics.put("NOC", noc.calculateWithRegex(codeString));
		metrics.put("NOM", nom.calculateWithRegex(codeString));
		return metrics;
	}

}