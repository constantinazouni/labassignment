package codeanalyzer.readers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Reads the contents of a given web file
 * and stores it either in a String or a List
 * @author agkortzis, constantinazouni
 * 
 */
public class WebFileReader implements SourceFileReader {
  /**
   * Reads a local file and returns its content 
   * in a String
   * @param filepath, the path of the input file
   * @return a String that contains the contents of the file
   * @throws IOException
   */
  public String readFileIntoString(String filepath) throws IOException {
    StringBuilder sb = new StringBuilder();
    URL url = new URL(filepath);
    BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
    String line = null;
    while ((line = reader.readLine()) != null) {
      sb.append(line + "\n");
    }
    reader.close();
    return sb.toString();
  }

  /**
   * Reads a local file and returns its content
   * in a List
   * @param filepath, the path of the input file
   * @return a List that contains the contents of the file 
   * @throws IOException
   */
  public List<String> readFileIntoList(String filepath) throws IOException {
    List<String> lines = new ArrayList<>();
    URL url = new URL(filepath);
    BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
    String line = null;
    while ((line = reader.readLine()) != null) {
      lines.add(line);
    }
    reader.close();
    return lines;
  }
}