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
  public void testFactorial_negativeInput_expectedIllegalArgumentException() {
    exp.expect(IllegalArgumentException.class);
    exp.expectMessage("x should be >= 0");
    math.factorial(-1);
  }

  @Test
  public void testFactorial_outOfBoundsInput_expectedIllegalArgumentException() {
    exp.expect(IllegalArgumentException.class);
    exp.expectMessage("x should be <= 12");
    math.factorial(13);
  }
}