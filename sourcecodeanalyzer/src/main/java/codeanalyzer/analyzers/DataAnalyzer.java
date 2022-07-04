package codeanalyzer.analyzers;

import java.util.Map;
import java.io.IOException;

/**
 * An interface for different types of analyzers
 * @author constantinazouni
 */
public interface DataAnalyzer {
	public Map<String, Integer> calculateMetrics(String filepath, String sourceFileLocation) throws IOException;

}