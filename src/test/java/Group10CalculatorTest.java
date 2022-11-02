package test.java;

import static org.junit.Assert.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.*;

import main.java.Group10Calculator;

import java.util.*;

public class Group10CalculatorTest {
    public  ArrayList<String> testList=new ArrayList<String>(0);
    public  ArrayList<String> expectedList=new ArrayList<String>(0);
    @Test
    public void addBasic() {
        org.junit.Assert.assertEquals((7), (Group10Calculator.evaluate("5+2")));
    }
    @Test
    public void addAndSubtract() {
        org.junit.Assert.assertEquals(8, Group10Calculator.evaluate("5+6-3"));
    }

    @Test
    public void multiply() {
        org.junit.Assert.assertEquals(10, Group10Calculator.evaluate(" 5*2"));
    }

    @Test
    public void addAndMultiply() {
        org.junit.Assert.assertEquals(25, Group10Calculator.evaluate("5+4*5"));
    }

    @Test
    public void subtractAndMultiply() {
        org.junit.Assert.assertEquals(-7, Group10Calculator.evaluate("5-6*2"));
    }

   /*  @Test
    public void invalidDuplicateOperator() {
        org.junit.Assert.assertEquals(0, Group10Calculator.evaluate("5++2"));
    }*/

    @Test
    public void invalidExpression() {
        org.junit.Assert.assertEquals(0, Group10Calculator.evaluate("5+2ergerg"));
    }
    @Test
    public void invalidDouble(){
        org.junit.Assert.assertEquals(0, Group10Calculator.evaluate("5.2+4.3"));
    }
    @Test
    public void Power(){
        org.junit.Assert.assertEquals(4, Group10Calculator.evaluate("2^2"));
    }
    @Test
    public void Divide(){
        org.junit.Assert.assertEquals(8, Group10Calculator.evaluate("16/2"));
    }
  /*@Test
  public void expBasic(){
    org.junit.Assert.assertEquals(54.598, Group10Calculator.evaluate("exp(4)"));
  }
  @Test
  public void expBasic(){
    org.junit.Assert.assertEquals(30.786, Group10Calculator.evaluate("3+5*exp(4.2)/(5+7)"));
  }
  */

}

