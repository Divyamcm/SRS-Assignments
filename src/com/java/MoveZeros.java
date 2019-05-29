package com.java;

public class MoveZeros {
	public static void main(String[] args) {
		int[] a = { 0, 3, 0, 5, 9, 10, 4, 0, 5, 0, 3 };
		int n = a.length;
		int temp;
		int j = 0;

		for (int i = 0; i < n; i++) {

			if ((a[i] != 0)) {
				temp = a[j];
				a[j] = a[i];
				a[i] = temp;
				j = j + 1;
			}
		}
        System.out.print("Output Array is:");
		for (int k = 0; k < a.length; k++) {
			System.out.print(" " + a[k]);
		}
	}
}
