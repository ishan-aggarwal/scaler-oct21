package week29.day75.classwork;

import java.util.Arrays;

//Q5. Minimum number of Perfect Square sum as K()
//Given a number K. Find the minimum number of perfect squares needed to achieve the sum K.
public class MinPerfectSquareKMemoization {

	// TC - O(Sqrt(N) * N)
	public static int minPerfectSqaresSumAsN(int n, int[] dp) {

		// base cases
		if (n <= 0)
			return 0;

		if (n <= 3)
			return n;

		if (dp[n] == Integer.MAX_VALUE) {
			for (int i = 1; i <= Math.sqrt(n); i++) {
				dp[n] = Math.min(dp[n], 1 + minPerfectSqaresSumAsN(n - i * i, dp));
			}
		}

		return dp[n];
	}

	public static void main(String[] args) {
		int[] dp = new int[5];
		Arrays.fill(dp, Integer.MAX_VALUE);
		System.out.println("4  = " + minPerfectSqaresSumAsN(4, dp));
		dp = new int[12];
		Arrays.fill(dp, Integer.MAX_VALUE);
		System.out.println("11 = " + minPerfectSqaresSumAsN(11, dp));
		dp = new int[13];
		Arrays.fill(dp, Integer.MAX_VALUE);
		System.out.println("12 = " + minPerfectSqaresSumAsN(12, dp));
	}
}
