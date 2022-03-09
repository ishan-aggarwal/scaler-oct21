package leetcode.march;

class CountAllValidPickupAndDelivery_Day6_2 {

	// Approach 1: Recursion with Memoization (Top-Down DP)
	private static int MOD = 1000000007;
	private static long[][] dp;

	public static int countOrders(int n) {
		dp = new long[n + 1][n + 1];
		return (int) totalWays(n, n);
	}

	private static long totalWays(int unpicked, int undelivered) {
		if (unpicked == 0 && undelivered == 0) {
			// We have completed all orders.
			return 1;
		}

		if (unpicked < 0 || undelivered < 0 || undelivered < unpicked) {
			// We can't pick or deliver more than N items
			// Number of deliveries can't exceed number of pickups
			// as we can only deliver after a pickup.
			return 0;
		}

		if (dp[unpicked][undelivered] != 0) {
			// Return cached value, if already present.
			return dp[unpicked][undelivered];
		}

		long ans = 0;

		// Count all choices of picking up an order.
		ans += unpicked * totalWays(unpicked - 1, undelivered);
		// Handle integer overflow.
		ans %= MOD;

		// Count all choices of delivering a picked order.
		ans += (undelivered - unpicked) * totalWays(unpicked, undelivered - 1);
		// Handle integer overflow.
		ans %= MOD;

		dp[unpicked][undelivered] = ans;
		return dp[unpicked][undelivered];
	}
}