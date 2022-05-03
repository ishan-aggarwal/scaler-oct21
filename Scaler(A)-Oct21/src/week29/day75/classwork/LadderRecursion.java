package week29.day75.classwork;

// Q2. Ladder Problem (Amazon, MS, Adobe, Flipkart)
// Given N stairs. Count the number of ways of going from 
// 0th to Nth step.
// Given that from ith step you can go to (i+1)th or (i+2)th step.

public class LadderRecursion {

	// TC - O(2^N)
	// SC - O(N)
	public static int countWays(int n) {
		if (n <= 2)
			return n;

		return countWays(n - 1) + countWays(n - 2);
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
