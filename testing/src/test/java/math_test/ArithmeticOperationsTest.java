package math;

import org.junit.Test;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

public class ArithmeticOperationsTest {
  ArithmeticOperations arithm = new ArithmeticOperations();

  @Rule
  public ExpectedException exp = ExpectedException.none();

  @Test
  public void testDivide_validInput() {
    Assert.assertEquals(5.0, arithm.divide(10.0, 2.0), 0.0001);
    Assert.assertEquals(-5.0, arithm.divide(10.0, -2.0), 0.0001);
    Assert.assertEquals(5.0, arithm.divide(-10.0, -2.0), 0.0001);
    
    Assert.assertEquals(0.0, arithm.divide(0.0, 2.0), 0.0001);
    Assert.assertEquals(0.0, arithm.divide(0.0, -2.0), 0.0001);
    Assert.assertEquals(0.0, arithm.divide(-0.0, -2.0), 0.0001);
    
    Assert.assertEquals(2.5, arithm.divide(10.0, 4.0), 0.0001);
    Assert.assertEquals(-2.5, arithm.divide(10.0, -4.0), 0.0001);
    Assert.assertEquals(2.5, arithm.divide(-10.0, -4.0), 0.0001);    
  }
 
  @Test (expected = ArithmeticException.class)
  public void testDivide_divisionWithZero() {
    arithm.divide(10.0, 0.0);
  }

  @Test
  public void testMultiply_validInput() {
    Assert.assertEquals(10, arithm.multiply(2, 5));    
    Assert.assertEquals(1368, arithm.multiply(3, 456));
    Assert.assertEquals(100, arithm.multiply(10, 10));
    Assert.assertEquals(0, arithm.multiply(0, 10));   
  }

  @Test
  public void testMultiply_negativeInput() {    
    exp.expect(IllegalArgumentException.class);
    exp.expectMessage("x & y should be >= 0");
    arithm.multiply(-2, 5);
    arithm.multiply(2, -5);
    arithm.multiply(-2, -5);
  }

  @Test
  public void testMultiply_outOfBoundsProduct() {    
    exp.expect(IllegalArgumentException.class);
    exp.expectMessage("The product does not fit in an Integer variable");
    arithm.multiply(Integer.MAX_VALUE/2, 5);
  }
  
}