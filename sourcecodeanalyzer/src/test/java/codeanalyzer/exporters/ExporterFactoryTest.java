package codeanalyzer.exporters;

import org.junit.Test;

public class ExporterFactoryTest {
  private ExporterFactory factory = new ExporterFactory();
  private final String wrong_type = "wrong-type";

  @Test (expected = IllegalArgumentException.class)
  public void testInitializeExporter_WrongType() {
    factory.initializeExporter(wrong_type);
  }

}