package com.java;

public class NonRepeatingCharIndex {
	public static void main(String[] args) {
		String s = "Write a java program to find the index of first non-repeating\r\n" + 
				"character in a given string";
		s = s.replaceAll("\\s","");
		for (int i = 0; i < s.length(); i++) {
			boolean uniqueChar = true;
			for (int j = 0; j < s.length(); j++) {
				if (i != j && s.charAt(i) == s.charAt(j)) {
					uniqueChar = false;
					break;
				}
			}
			if (uniqueChar) {
				System.out.println("Index of first non repeating character is "+i);
				break;
			}
		}
	}
}
