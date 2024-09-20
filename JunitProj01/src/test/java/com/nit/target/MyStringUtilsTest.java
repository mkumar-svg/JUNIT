package com.nit.target;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class MyStringUtilsTest {
	private static MyStringUtils util;
	
	@BeforeAll
	public static void setupOnce() {
		util = new MyStringUtils();
	}
	
	@ParameterizedTest
	@ValueSource(strings = {"madam","level", "racecar","liril","nitin", "121", "malayalam"})
	public void isPlaindromeTest(String s) {
		boolean actual = util.isPalindrome(s);
		assertTrue(actual);
	}
	
	@Test
	public void convertStringToIntTestForIAE() {
		assertThrows(IllegalArgumentException.class, ()->util.convertStringToInt(null));
	}
	
	@Test
	public void convertStringToIntTestForNFE() {
		assertThrows(NumberFormatException.class, ()->util.convertStringToInt("10r"));
	}
	
	@Test
	public void convertStringToIntTest() {
		assertEquals(10, util.convertStringToInt("10"));
	}
	
	@AfterAll
    public static void tearDownOnce() {
    	util = null;
    }
}
