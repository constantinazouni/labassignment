package codeanalyzer.readers;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;
import org.junit.BeforeClass;
import org.junit.Test;

public class WebFileReaderTest {
  	private WebFileReader wfr = null;
	private static List<String> expectedList;
	private static String expectedString;
  	private final static String TEST_CLASS_WEB = "https://drive.google.com/uc?export=download&id=1z51FZXqPyun4oeB7ERFlOgfcoDfLLLhg";

  	@BeforeClass
	public static void setUp() throws IOException {
		expectedList = Files.readAllLines(new File("src/test/resources/TestClass.java").toPath(), Charset.defaultCharset()); // reads the local file
		expectedString = String.join("\n", expectedList) + "\n"; // transforms a list into a String (with 'new line' as delimiter) 
	}

  	@Test
	public void testReadFileIntoListWeb() throws IOException {
    	// reads a web stored file into a List    
		wfr = new WebFileReader();
		List<String> actualList = wfr.readFileIntoList(TEST_CLASS_WEB);
		
		String[] expecteds = expectedList.stream().toArray(String[]::new);
		String[] actuals = actualList.stream().toArray(String[]::new);
		
		assertArrayEquals(expecteds, actuals);
	}
	
	@Test
	public void testReadFileIntoStringWeb() throws IOException {
		// reads a web stored file into a String
	    wfr = new WebFileReader();
	    String actualString = wfr.readFileIntoString(TEST_CLASS_WEB);
	    
	    String expecteds = expectedString;
	    String actuals = actualString;
				
		assertEquals(expecteds, actuals);
	}
  
}