package codeanalyzer.analyzers;

import org.junit.Test;

public class DataAnalyzerFactoryTest {
  private DataAnalyzerFactory factory = new DataAnalyzerFactory();
  private String wrong_type = "wrong_type";

  @Test (expected = IllegalArgumentException.class)
  public void testInitializeAnalyzer_WrongType() {
    factory.initializeAnalyzer(wrong_type);
  }
  

}