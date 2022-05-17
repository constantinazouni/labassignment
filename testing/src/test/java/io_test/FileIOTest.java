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
  public void testReadFile_validArrayInputTesting() {
    int[] expectedValidSample = {2, 3, 4, 6, -1, 10, 7, -2, 1, 1, 2, 18, 10, 20,
        24, -1, -4, 22, 22, 444, 700, 1000};
    filepath = new File("src/test/resources/valid_input.txt").getAbsolutePath();
    Assert.assertArrayEquals(expectedValidSample, fileio.readFile(filepath));
  }

  

}