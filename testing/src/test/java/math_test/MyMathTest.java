package math;

import org.junit.Test;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

public class MyMathTest {
  MyMath math = new MyMath();

  @Rule
  public ExpectedException exp = ExpectedException.none();

  @Test
  public void testFactorial_negativeInput() {
    exp.expect(IllegalArgumentException.class);
    exp.expectMessage("x should be >= 0");
    math.factorial(-1);
  }

  @Test
  public void testFactorial_outOfBoundsInput() {
    exp.expect(IllegalArgumentException.class);
    exp.expectMessage("x should be <= 12");
    math.factorial(13);
  }

  @Test
  public void testIsPrime_validInput_prime() { 
    Assert.assertTrue(math.isPrime(2));
    Assert.assertTrue(math.isPrime(3));
    Assert.assertTrue(math.isPrime(5));
    Assert.assertTrue(math.isPrime(7));
    Assert.assertTrue(math.isPrime(11));
    Assert.assertTrue(math.isPrime(13));
    Assert.assertTrue(math.isPrime(17));
    Assert.assertTrue(math.isPrime(19));
    Assert.assertTrue(math.isPrime(23));
    Assert.assertTrue(math.isPrime(29));
  }

  @Test
  public void testIsPrime_validInput_notPrime() {   
    Assert.assertFalse(math.isPrime(4));
    Assert.assertFalse(math.isPrime(6));
    Assert.assertFalse(math.isPrime(8));
    Assert.assertFalse(math.isPrime(9));
    Assert.assertFalse(math.isPrime(10));
    Assert.assertFalse(math.isPrime(12));
    Assert.assertFalse(math.isPrime(14));
    Assert.assertFalse(math.isPrime(48));
    Assert.assertFalse(math.isPrime(234));
    Assert.assertFalse(math.isPrime(1729));    
  }

  @Test
  public void testIsPrime_invalidInput() {
    exp.expect(IllegalArgumentException.class);
    exp.expectMessage("x should be >= 2");
    math.isPrime(1);
  }
  
}