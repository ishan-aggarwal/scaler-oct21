package week29.day75.classwork;

import java.util.Arrays;

//Q5. Minimum number of Perfect Square sum as K()
//Given a number K. Find the minimum number of perfect squares needed to achieve the sum K.
public class MinPerfectSquareKTabulation {

	// TC - O(Sqrt(N) * N)
	public static int minPerfectSqaresSumAsN(int n) {

		// base case
		// just to avoid out of bounds error
		if (n <= 3) {
			return n;
		}

		int[] dp = new int[n + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 3;
		for (int i = 4; i <= n; i++) {
			// the max value for any number can be the number itself 1^2 + 1^2 + 1^2 + 1^2
			// ....
			dp[i] = i;
			for (int j = 1; j <= Math.sqrt(i); j++) {
				dp[i] = Math.min(dp[i], 1 + dp[i - j * j]);
			}
		}
		return dp[n];
	}

	public static void main(String[] args) {
		System.out.println("4  = " + minPerfectSqaresSumAsN(4));
		System.out.println("11 = " + minPerfectSqaresSumAsN(11));
		System.out.println("12 = " + minPerfectSqaresSumAsN(12));
	}
}
