package com.nit.target;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Unit test for simple App.
 */
public class CalculatorServiceTest {
	
	private static CalculatorService service;
	
	@BeforeAll
	public static void setupOnce() {
		service = new CalculatorService();
	}

    @Test
    public void testAddWithPositives() {
    	int actual = service.add(10, 20);
    	int expected = 30;
    	assertEquals(expected, actual);
    }
    
    @Test
    public void testAddWithNegative() {
    	int actual = service.add(-10, -20);
    	int expected = -30;
    	assertEquals(expected, actual);
    }
    
    @Test
    public void testAddWithZeros() {
    	int actual = service.add(0, 0);
    	int expected = 0;
    	assertEquals(expected, actual);
    }
    
    @Test
    public void testMulWithPositives() {
    	int actual = service.mul(10, 20);
    	int expected = 200;
    	assertEquals(expected, actual);
    }
    
    @Test
    @DisplayName("Testing Mul method with negatives")
    public void testMulWithNegatives() {
    	int actual = service.mul(-10, -20);
    	int expected = 200;
    	assertEquals(expected, actual);
    }
    
    @Test
    @Disabled
    public void testMulWithMixed() {
    	int actual = service.mul(10, -20);
    	int expected = -200;
    	assertEquals(expected, actual);
    }
    
    @AfterAll
    public static void tearDownOnce() {
    	service = null;
    }
    
}
