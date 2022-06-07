package codeanalyzer.readers;

/**
 * A factory class to initialize the
 * appropriate SourceFileReader object depending on
 * the file location
 * @author agkortzis, constantinazouni
 *  
 */
public class FileReaderFactory {
  /**
   * Initializes the appropriate SourceFileReader
   * object and returns it.
   * @param sourceFileLocation, web or local 
   * @return a SourceFileReader object based on the location of the
   * input file
   */
  public SourceFileReader initializeSourceFileReader(String sourceFileLocation) {
    SourceFileReader reader = null;
    if(sourceFileLocation.equals("local")) {
      reader = new LocalFileReader();
    } else if(sourceFileLocation.equals("web")) {
      reader = new WebFileReader();
    } else {
      throw new IllegalArgumentException("Please enter local or web file location");
    }
    return reader;
  }

}