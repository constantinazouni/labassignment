package math;

import io.FileIO;
import math.MyMath;
import java.util.List;
import java.util.ArrayList;

/**
 * ArrayOperations finds all prime natural numbers that are contained in a file.
 * @author constantinazouni
 * @version 1.0
 * @since 2022-05-18
 */
public class ArrayOperations {

  /**
   * Finds all primes natural numbers inside a file. 
   * @param fileIo the object to call readFile method
   * @param filepath the filepath of the .txt file
   * @param myMath the object to call isPrime method
   * @return an array with all the prime natural numbers
   */
  public int[] findPrimesInsideFile(FileIO fileio, String filepath, MyMath math) {
    int[] numbers = fileio.readFile(filepath);
    List<Integer> primes = new ArrayList<>();
    for (int number:numbers) {
      try {
        if (math.isPrime(number)) 
          primes.add(number);
      } catch (IllegalArgumentException e) {
          //catches exception
      }
    }
    return primes.stream().mapToInt(Integer::intValue).toArray();
  }

}