package codeanalyzer.metrics;

import java.util.List;

/**
 * An interface to implement different types of Metrics.
 * @author constantinazouni
 */
public interface Metric {
  public int calculateWithRegex(String codeString);
  public int calculateWithStrcomp(List<String> codeList);

}