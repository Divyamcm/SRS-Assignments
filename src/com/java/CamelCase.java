package com.java;

public class CamelCase {

	public static void main(String[] args)
	{
String a = "Write a Java program to capitalize the first letter and other chaRActers in small letter of each word in a sentence.";
	 char arr[] = a.toCharArray();
	 boolean UpperCase = true;
	 for (int i = 0; i < arr.length; i++)
	   if (arr[i] == ' ' || arr[i] == '\t')
	     UpperCase = true;
	   else if (arr[i] != ' ' && UpperCase)
	   {
	     arr[i] = Character.toUpperCase(arr[i]);
	     UpperCase = false;
	   }
	   else {
		   arr[i] = Character.toLowerCase(arr[i]);
	   }
	 a = new String(arr);
	 
	 System.out.println(a);
}
}