package codeanalyzer.exporters;

import java.util.Map;

/**
 * An interface to implement different 
 * types of exporters
 * @author constantinazouni
 * 
 */
public interface Exporter {
  public void write(String outputFilepath, Map<String, Integer> metrics);

}