package math;

import java.util.ArrayList;

/**
 * MyMath contains mathematical methods that
 * are used for practicing in unit testing.
 * @author  Constantina Zouni 
 */
public class MyMath {

  /**
   * The factorial method is the function that multiplies 
   * the number that takes as an input by every natural number below it.  
   * Input number must be in the range [0, 12].  
   * @param x the input
   * @return the factorial of the x
   * @exception IllegalArgumentException when x < 0
   * @exception IllegalArgumentException when x > 12
   */
  public int factorial(int x) {
    if (x < 0) {
      throw new IllegalArgumentException("x should be >= 0");
    } else if (x > 12) {
      throw new IllegalArgumentException("x should be <= 12");
    } else if (x == 0) {
        return 1;
    }else {
        return x * factorial(x-1);
    }
  }
}