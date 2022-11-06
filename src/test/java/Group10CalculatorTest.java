
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class Group10CalculatorTest {

    @Test
    public void addBasic() {
        double a = Group10Calculator.evaluate("5+2");
        assertEquals(7, a,0);
    }
    @Test
    public void addAndSubtract() {
        double a = Group10Calculator.evaluate("5+6-3");
        assertEquals(8, a,0);
    }

    @Test
    public void multiply() {
        double a = Group10Calculator.evaluate("5*2");
        assertEquals(10, a,0);
    }

    @Test
    public void addAndMultiply() {
        double a = Group10Calculator.evaluate("5+4*5");
        assertEquals(25,a,0);
    }

    @Test
    public void subtractAndMultiply() {
        double a = Group10Calculator.evaluate("5-6*2");
        assertEquals(-7,a,0);
    }

    @Test
    public void invalidExpression() {
        double a = Group10Calculator.evaluate("5+2ergerg");
        assertEquals(0, a,0);
    }
    @Test
    public void Double(){
        double a = Group10Calculator.evaluate("5.2+4.3");
        assertEquals(9.5,a,0);
    }
    @Test
    public void Power(){
        double a = Group10Calculator.evaluate("2^2");
        assertEquals(4, a,0);
    }
    @Test
    public void Divide(){
        double a = Group10Calculator.evaluate("16/2");
        assertEquals(8, a,0);
    }
  @Test
  public void expBasic(){
      double a = Group10Calculator.evaluate("exp(4)");
    assertEquals(54.598, a,0.1);
  }

  @Test
  public void expComplex(){
      double a = Group10Calculator.evaluate("3+5*exp(4.2)/(5+7)");
    assertEquals(30.786,a,0.1);
  }


}
