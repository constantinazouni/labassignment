package codeanalyzer.exporters;

/**
 * A factory class to initialize an Exporter object depending
 * on the output type file
 * @author agkortzis, constantinazouni
 * 
 */
public class ExporterFactory {
  /**
   * Initializes the appropriate Exporter object and returns it
   * @param outputFileType, regex or strcomp
   * @return exporter, the appropriate type of exporter
   */
  public Exporter initializeExporter(String outputFileType) {
    Exporter exporter;
    if(outputFileType.equals("csv")) {
      exporter = new CSVExporter();
    } else if (outputFileType.equals("json")) {
      exporter = new JSONExporter();
    } else {
      throw new IllegalArgumentException("Please enter csv or json type");
    }
    return exporter;
  }

}