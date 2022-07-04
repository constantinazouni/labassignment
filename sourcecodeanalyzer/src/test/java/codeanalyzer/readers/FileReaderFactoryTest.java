package codeanalyzer.readers;

import org.junit.Test;

public class FileReaderFactoryTest {
  private FileReaderFactory factory = new FileReaderFactory();
  private String wrong_type = "wrong-type";

  @Test (expected = IllegalArgumentException.class)
  public void testInitializeSourceFileReader_WrongType() {
    factory.initializeSourceFileReader(wrong_type);
  }
  
}