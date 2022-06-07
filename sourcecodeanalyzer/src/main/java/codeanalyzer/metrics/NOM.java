package codeanalyzer.metrics;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Calculates the number of methods (NOM) for a code file with
 * regex or strcomp
 * @author agkortzis, constantinazouni
 * 
 */
public class NOM implements Metric {
  /**
   * Calculates nom using regular expressions.
   * @param sourceCodeString, the input file as a String
   * @return nom, number of methods
   */
  public int calculateWithRegex(String sourceCodeString) {
    Pattern pattern = Pattern.compile(".*(public |protected |private |static )?[\\w\\<\\>\\[\\]]+\\s+(\\w+) *\\([^\\)]*\\) *(\\{?|[^;]).*"); 
	  Matcher methodSignatures = pattern.matcher(sourceCodeString);
    int nom = 0;
    while (methodSignatures.find()) {
      nom++;
    }
    return nom;
  }

  /**
   * Calculates nom using string comparison.
   * @param sourceCodeList, the input file as a List
   * @return nom, number of methods
   */
  public int calculateWithStrcomp(List<String> sourceCodeList) {
    int nom = 0;
    for (String line : sourceCodeList) {
      line = line.trim(); // remove leading and trailing white spaces
      if ( ((line.contains("public") || line.contains("private") || line.contains("protected"))
          || line.contains("void") || line.contains("int") || line.contains("String"))
        && line.contains("(") && line.contains(")") && line.contains("{") )
        nom++;
    }
    return nom; 
  }

}