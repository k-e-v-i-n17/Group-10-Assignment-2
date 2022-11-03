import org.junit.*;

public class Group10CalculatorTest {

    @Test
    public void addBasic() {
        double a = Group10Calculator.evaluate("5+2");
        Assert.assertEquals(7, a,0);
    }
    @Test
    public void addAndSubtract() {
        double a = Group10Calculator.evaluate("5+6-3");
        Assert.assertEquals(8, a,0);
    }

    @Test
    public void multiply() {
        double a = Group10Calculator.evaluate("5*2");
        Assert.assertEquals(10, a,0);
    }

    @Test
    public void addAndMultiply() {
        double a = Group10Calculator.evaluate("5+4*5");
        Assert.assertEquals(25,a,0);
    }

    @Test
    public void subtractAndMultiply() {
        double a = Group10Calculator.evaluate("5-6*2");
        Assert.assertEquals(-7,a,0);
    }

    @Test
    public void invalidExpression() {
        double a = Group10Calculator.evaluate("5+2ergerg");
        Assert.assertEquals(0, a,0);
    }
    @Test
    public void Double(){
        double a = Group10Calculator.evaluate("5.2+4.3");
        Assert.assertEquals(9.5,a,0);
    }
    @Test
    public void Power(){
        double a = Group10Calculator.evaluate("2^2");
        Assert.assertEquals(4, a,0);
    }
    @Test
    public void Divide(){
        double a = Group10Calculator.evaluate("16/2");
        Assert.assertEquals(8, a,0);
    }
  @Test
  public void expBasic(){
      double a = Group10Calculator.evaluate("exp(4)");
    Assert.assertEquals(54.598, a,0.1);
  }

  @Test
  public void expComplex(){
      double a = Group10Calculator.evaluate("3+5*exp(4.2)/(5+7)");
    Assert.assertEquals(30.786,a,0.1);
  }


}
