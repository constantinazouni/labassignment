package codeanalyzer.readers;

import java.io.IOException;
import java.util.List;

/**
 * An interface to implement different type of file readers
 * @author constantinazouni
 */
public interface SourceFileReader {
	public String readFileIntoString(String filepath) throws IOException;
	public List<String> readFileIntoList(String filepath) throws IOException;

}