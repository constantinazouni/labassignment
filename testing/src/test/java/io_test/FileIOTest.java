package io;

import java.io.File;

import org.junit.Test;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

public class FileIOTest {
  FileIO fileio = new FileIO();
  String filepath;

  @Rule
  public ExpectedException exp = ExpectedException.none();

  @Test
  public void testReadFile_validArrayInput() {
    int[] expected_output = {2, 3, 4, 6, -1, 10, 7, -2, 1, 1, 2, 18, 10, 20,
        24, -1, -4, 22, 22, 444, 700, 1000};
    filepath = new File("src/test/resources/valid_input.txt").getAbsolutePath();
    Assert.assertArrayEquals(expected_output, fileio.readFile(filepath));
  }
  
  @Test
  public void testReadFile_notExistingInputFile() {
    filepath = new File("src/test/resources/not_existing_title.txt").getAbsolutePath();
    exp.expect(IllegalArgumentException.class);
    exp.expectMessage("Input file does not exist");
    fileio.readFile(filepath);
  }

  @Test
  public void testReadFile_emptyFile() {
    filepath = new File("src/test/resources/empty.txt").getAbsolutePath();
    exp.expect(IllegalArgumentException.class);
    exp.expectMessage("Given file is empty");
    fileio.readFile(filepath);
  }

  @Test
  public void testReadFileContainsInvalidEntries() {
    int[] expectedInvalidSample = {2, 3, 4, 6, -1, 10, 7, -2, 1, 1, 2, 10, 20,
      24, -1, -4, 22, 22, 700, 1000};
    filepath = new File("src/test/resources/invalid_input.txt").getAbsolutePath();
    Assert.assertArrayEquals(expectedInvalidSample, fileio.readFile(filepath));
  }

}