package math;

import io.FileIO;
import math.MyMath;
import math.ArrayOperations;
import java.io.File;

import org.junit.Test;
import org.junit.Assert;
import static org.mockito.Mockito.*;

public class ArrayOperationsTest {
  ArrayOperations arrayop = new ArrayOperations();
  String filepath;

  @Test
  public void testFindPrimesInsideFile_validInput() {     
    filepath = new File("src/test/resources/valid_input.txt").getAbsolutePath();    
    FileIO fileio = mock(FileIO.class);
    MyMath math = mock(MyMath.class);
    when(fileio.readFile(filepath)).thenReturn(new int[]
      {2, 3, 8, 11, 13, 48, 234});
    int[] output = {2, 3, 11, 13};     
    when(math.isPrime(2)).thenReturn(true);  
    when(math.isPrime(3)).thenReturn(true);  
    when(math.isPrime(8)).thenReturn(false);
    when(math.isPrime(11)).thenReturn(true);
    when(math.isPrime(13)).thenReturn(true);  
    when(math.isPrime(48)).thenReturn(false);
    when(math.isPrime(234)).thenReturn(false);
    Assert.assertArrayEquals(output, arrayop.findPrimesInsideFile(fileio, filepath, math));
  }

  @Test
  public void testFindPrimesInsideFile_invalidInput() { 
    filepath = new File("src/test/resources/valid_input.txt").getAbsolutePath();    
    FileIO fileio = mock(FileIO.class);
    MyMath math = mock(MyMath.class);
    when(fileio.readFile(filepath)).thenReturn(new int[]
      {-2, -1, 0, 1});
    int[] output = {};
    when(math.isPrime(-2)).thenThrow(new IllegalArgumentException());
    when(math.isPrime(-1)).thenThrow(new IllegalArgumentException());
    when(math.isPrime(0)).thenThrow(new IllegalArgumentException());  
    when(math.isPrime(1)).thenThrow(new IllegalArgumentException());   
    Assert.assertArrayEquals(output, arrayop.findPrimesInsideFile(fileio, filepath, math));
  }
  
}