package com.nit.target;

public class MyStringUtils {
	
	public boolean isPalindrome(String s) {
		int length = s.length();
		StringBuilder reverse = new StringBuilder();
		for(int i = length-1; i>=0; i--) {
			reverse.append(s.charAt(i));
		}
		System.out.println(s + " " + reverse);
		
		if(s.equals(reverse.toString()))
			return true;
		else
			return false;
	}
	
	public Integer convertStringToInt(String s) {
		if(s == null || s.length() == 0 || s.equals("")) {
			throw new IllegalArgumentException("Given input must not be null or empty");
		} else {
			return Integer.parseInt(s);
		}
	}

}
