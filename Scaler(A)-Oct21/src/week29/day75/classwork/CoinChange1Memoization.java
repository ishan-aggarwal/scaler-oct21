package week29.day75.classwork;

import java.util.Arrays;

// Q4. Coin Change - 1 (Unboxed and many others)
// Given some coins with their values & a value k.
// Count the number of getting the sum k by using the coins.
// One coin can be used multiple times
public class CoinChange1Memoization {

	// let length of coins array be n
	// TC - O(n*k)
	// SC - O(k)
	public static int countWays(int[] coins, int k, int[] dp) {

		if (k < 0)
			return 0;

		if (k == 0)
			return 1;

		if (dp[k] == 0) {
			for (int i = 0; i < coins.length; i++) {
				dp[k] += countWays(coins, k - coins[i], dp);
			}
		}

		return dp[k];
	}

	public static void main(String[] args) {
		int[] coins = { 1, 2, 5, 7 };
//		here k = 3; so dp array is created of size k + 1
		int[] dp = new int[4];
		Arrays.fill(dp, 0);
		System.out.println(countWays(coins, 3, dp));
		dp = new int[8];
		Arrays.fill(dp, 0);
		System.out.println(countWays(coins, 7, dp));
	}
}
