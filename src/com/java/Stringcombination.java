package com.java;

public class Stringcombination {

	public static void main(String[] args) {

		String s = "ABC";
		int n = s.length();
		Stringcombination sc = new Stringcombination();
		sc.combination(s, 0, n - 1);
	}

	private void combination(String str, int l, int r) {
		if (l == r)
			System.out.println(str);
		else {
			for (int i = l; i <= r; i++) {
				str = swap(str, l, i);
				combination(str, l + 1, r);
				str = swap(str, l, i);
			}
		}
	}

	public String swap(String a, int i, int j) {
		char temp;
		char[] charArray = a.toCharArray();
		temp = charArray[i];
		charArray[i] = charArray[j];
		charArray[j] = temp;
		return String.valueOf(charArray);
	}

}
