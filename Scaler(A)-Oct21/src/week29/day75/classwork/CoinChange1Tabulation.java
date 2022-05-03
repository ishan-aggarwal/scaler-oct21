package week29.day75.classwork;

// Q4. Coin Change - 1 (Unboxed and many others)
// Given some coins with their values & a value k.
// Count the number of getting the sum k by using the coins.
// One coin can be used multiple times
public class CoinChange1Tabulation {

	// let length of coins array be n
	// TC - O(n*k)
	// SC - O(k)
	public static int countWays(int[] coins, int k) {
		int[] dp = new int[k + 1];
		dp[0] = 1;
		dp[1] = 1;

		for (int i = 2; i <= k; i++) {
			for (int j = 0; j < coins.length; j++) {
				if (i - coins[j] >= 0) {
					dp[i] += dp[i - coins[j]];
				}
			}
		}
		return dp[k];
	}

	public static void main(String[] args) {
		int[] coins = { 1, 2, 5, 7 };
		System.out.println(countWays(coins, 3));
		System.out.println(countWays(coins, 7));
	}
}
