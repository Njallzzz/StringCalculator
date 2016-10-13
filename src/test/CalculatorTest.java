package stringcalculator;

import static org.junit.Assert.*;

import org.junit.rules.ExpectedException;
import org.junit.Test;

public class CalculatorTest { 
    @Test
    public void EmptyString() {
        assertEquals(0, Calculator.add(""));
    }
    
    @Test
    public void OneNumberCommaSepString() {
        assertEquals(1, Calculator.add("1"));
    }
    
    @Test
    public void TwoNumbersCommaSepString() {
        assertEquals(3, Calculator.add("1,2"));
    }
    
    @Test
    public void ThreeNumbersCommaSepString() {
        assertEquals(6, Calculator.add("1,2,3"));
    }
    
    @Test
    public void TwoNumbersCombSepString() {
        assertEquals(3, Calculator.add("1\n2"));
    }
    
    @Test
    public void ThreeNumbersCombSepString() {
        assertEquals(15, Calculator.add("5,4\n6"));
    }
    
    @Test
    public void ThreeNumbersCombSepOneInvalidString() {
        assertEquals(4, Calculator.add("1\n1003,3"));
    }
    
    @Test
    public void ThreeNumbersNewlineSepThreeInvalidString() {
        assertEquals(0, Calculator.add("5003\n1003\n12345"));
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void ThreeNumbersNewlineSepOneNegativeNumbersString() {
        try {
            Calculator.add("1\n-3\n8");
        } catch ( IllegalArgumentException m ) {
            String message = "Negatives not allowed: -3";
            assertEquals(message, m.getMessage());
            throw m;
        }
        fail("ThreeNumbersNewlineSepOneNegativeNumbersString");
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void ThreeNumbersNewlineSepTwoNegativeNumbersString() {
        try {
            Calculator.add("-2\n-9\n8");
        } catch ( IllegalArgumentException m ) {
            String message = "Negatives not allowed: -2,-9";
            assertEquals(message, m.getMessage());
            throw m;
        }
        fail("ThreeNumbersNewlineSepTwoNegativeNumbersString");
    }
    
    @Test
    public void TwoNumbersDifferentDelimiter() {
        assertEquals(8, Calculator.add("//;\n3;5"));
    }
}