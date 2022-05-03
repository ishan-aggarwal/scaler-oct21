package week29.day75.classwork;

import java.util.Arrays;

// Q2. Ladder Problem (Amazon, MS, Adobe, Flipkart)
// Given N stairs. Count the number of ways of going from 
// 0th to Nth step.
// Given that from ith step you can go to (i+1)th or (i+2)th step.

public class LadderTabulation {

	// TC - O(N)
	// SC - O(N)
	public static int countWays(int n) {
		if (n <= 2)
			return n;

		int[] result = new int[n + 1];
		result[0] = 1;
		result[1] = 1;

		for (int i = 2; i <= n; i++) {
			result[i] = result[i - 1] + result[i - 2];
		}
		return result[n];
	}

	public static void main(String[] args) {
		System.out.println(countWays(1));
		System.out.println(countWays(2));
		System.out.println(countWays(3));
		System.out.println(countWays(4));
		System.out.println(countWays(5));
		System.out.println(countWays(6));
	}
}
