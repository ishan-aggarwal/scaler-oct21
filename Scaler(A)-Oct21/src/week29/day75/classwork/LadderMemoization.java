package week29.day75.classwork;

import java.util.Arrays;

// Q2. Ladder Problem (Amazon, MS, Adobe, Flipkart)
// Given N stairs. Count the number of ways of going from 
// 0th to Nth step.
// Given that from ith step you can go to (i+1)th or (i+2)th step.

public class LadderMemoization {

	static int[] result = new int[100];

	static {
		Arrays.fill(result, -1);
	}

	// TC - O(N)
	// SC - O(N)
	public static int countWays(int n) {
		if (n <= 2)
			return n;

		if (result[n] == -1) {
			result[n] = countWays(n - 1) + countWays(n - 2);
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
