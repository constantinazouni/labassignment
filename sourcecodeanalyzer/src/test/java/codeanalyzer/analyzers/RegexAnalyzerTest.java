package codeanalyzer.analyzers;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class RegexAnalyzerTest {
  private static String inputFile = "src/test/resources/TestClass.java";
  private static String inputFileLocation = "local";
  private DataAnalyzer analyzer = new RegexAnalyzer();

  @Test
  public void testCalculateMetricsWithRegex() throws IOException {
    Map<String, Integer> expectedMetrics = new HashMap<String, Integer>();  
    expectedMetrics.put("LOC", 21);
    expectedMetrics.put("NOM", 3);
    expectedMetrics.put("NOC", 3);
    Map<String, Integer> metricsResult = new HashMap<String, Integer>();
    metricsResult = analyzer.calculateMetrics(inputFile, inputFileLocation);
    
    assertEquals(metricsResult, expectedMetrics);
  }

}