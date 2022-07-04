package codeanalyzer;

import java.io.IOException;
import java.util.Map;

import codeanalyzer.analyzers.*;
import codeanalyzer.exporters.*;

/**
 * A facade class that implement the 
 * source code analysis
 * @author constantinazouni
 *
 */
public class AnalyzerFacade {
	/**
	 * Performs the source code analysis.
	 * @param sourceFilepath, the path of the input file
     * @param sourceFileLocation, web or local
     * @param sourceCodeAnalyzerType, regex or strcomp
     * @param outputFilepath, the path of the output file
     * @param outputFileType, the format of the output file
	 */
	public void analyze(String sourceFilepath, String sourceFileLocation, String sourceCodeAnalyzerType, String outputFilepath, String outputFileType) throws IOException {
		DataAnalyzerFactory analyzerFactory = new DataAnalyzerFactory();
		DataAnalyzer analyzer = analyzerFactory.initializeAnalyzer(sourceCodeAnalyzerType);
		Map<String, Integer> metrics = analyzer.calculateMetrics(sourceFilepath, sourceFileLocation);
		ExporterFactory exporterFactory = new ExporterFactory();
		Exporter exporter = exporterFactory.initializeExporter(outputFileType);
		exporter.write(outputFilepath, metrics);
	}

}