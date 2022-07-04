package codeanalyzer.metrics;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import codeanalyzer.readers.LocalFileReader;

public class NOCTest {
  private String sourceFilepath = "src/test/resources/TestClass.java";
  private NOC noc = new NOC();
  private LocalFileReader lfr = new LocalFileReader(); 

  @Test
	public void testCalculateRegex() throws IOException {
    String testSourceCodeString = lfr.readFileIntoString(sourceFilepath);
		assertEquals(3, noc.calculateWithRegex(testSourceCodeString));
  }
  
  @Test
	public void testCalculateStrcomp() throws IOException {
    List<String> testSourceCodeList = lfr.readFileIntoList(sourceFilepath);
		assertEquals(3, noc.calculateWithStrcomp(testSourceCodeList));
  }
  
}