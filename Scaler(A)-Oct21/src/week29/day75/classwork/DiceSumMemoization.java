package week29.day75.classwork;

import java.util.Arrays;

// Q3. Dice Sum
// Given one 6 faced dice and a number N.
// Count the number of ways to get a sum of N 
// if you can roll dice as many times as you want.
public class DiceSumMemoization {

	private static int[] dp = new int[100];

	static {
		Arrays.fill(dp, -1);
	}

	// TC - (No. of function calls in the tree) * TC of one function call excluding
	// the recursion
	// So - (N * O(1) - which is 6 operations ) = O(N)
	// TC - O(N)
	// SC - O(N)
	public static int countWays(int n) {

		if (n < 0)
			return 0;

		if (n <= 1)
			return 1;

		if (dp[n] == -1) {
			dp[n] = countWays(n - 1) + countWays(n - 2) + countWays(n - 3) + countWays(n - 4) + countWays(n - 5)
					+ countWays(n - 6);
		}

		return dp[n];
	}

	private static int findWays(int N, int dp[]) {
		// Base Case
		if (N < 0) {
			return 0;
		}
		if (N <= 1) {
			return 1;
		}

		int ans = 0;
		if (dp[N] == -1) {
			for (int i = 1; i <= 6; i++) {
				ans += findWays(N - i, dp);
			}
			dp[N] = ans;
		}
		// Return the result
		return dp[N];
	}

	public static void main(String[] args) {
		System.out.println(countWays(1));
		System.out.println(countWays(2));
		System.out.println(countWays(3));
		System.out.println(countWays(4));
		System.out.println(countWays(5));
		System.out.println(countWays(6));

		System.out.println("-------------");
		int[] dp1 = new int[7];
		Arrays.fill(dp1, -1);
		System.out.println(findWays(6, dp1));
	}
}
