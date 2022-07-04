package codeanalyzer.metrics;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Calculates the lines of code of a code file with
 * regex or strcomp
 * @author agkortzis, constantinazouni
 * 
 */
public class LOC implements Metric {
  /**
   * Calculates loc using regular expressions
   * @param sourceCodeString, the input file as a String
   * @return loc, lines of code
   */  
 
  public int calculateWithRegex(String sourceCodeString) {
    Pattern pattern = Pattern.compile("((//.*)|(/\\*.*)|(\\*+.*))");
    Matcher nonCodeLinesMatcher = pattern.matcher(sourceCodeString);
    int nonCodeLinesCounter = 0;
    while (nonCodeLinesMatcher.find()) {
      nonCodeLinesCounter++;
    }
    int sourceFileLength = sourceCodeString.split("\n").length;
    int loc = sourceFileLength - nonCodeLinesCounter;
    return loc;
  }

  /**
   * Calculates loc using string comparison
   * @param sourceCodeString, the input file as a List
   * @return loc, lines of code
   */
  public int calculateWithStrcomp(List<String> sourceCodeList) {
    int nonCodeLinesCounter = 0;
    for (String line : sourceCodeList) {
      line = line.trim(); // remove leading and trailing white spaces
      if (line.startsWith("//") || line.startsWith("/*") || line.startsWith("*") || line.equals("{") || line.equals("}")
          || line.equals(""))
        nonCodeLinesCounter++;
    }
    int loc = sourceCodeList.size() - nonCodeLinesCounter;
    return loc;
  }

}