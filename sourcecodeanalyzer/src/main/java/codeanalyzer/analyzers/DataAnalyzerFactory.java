package codeanalyzer.analyzers;

/**
 * A factory class for initialing Analyzers based on the analyzer type
 * @author agkortzis
 * @author constantinazouni
 */
public class DataAnalyzerFactory {
  /**
   * Initializes Analyzer depending on it's type
   * and returns it.
   * @param analyzerType, regex or strcomp
   * @return analyzer, the correct object based on the type
   */
  public DataAnalyzer initializeAnalyzer(String analyzerType) {
    DataAnalyzer analyzer;
    if(analyzerType.equals("regex")) {
      analyzer = new RegexAnalyzer();
    } else if (analyzerType.equals("strcomp")) {
      analyzer = new StringComparisonAnalyzer();
    } else {
      throw new IllegalArgumentException("Please enter regex or strcomp type");
    }
    return analyzer;
  }

}