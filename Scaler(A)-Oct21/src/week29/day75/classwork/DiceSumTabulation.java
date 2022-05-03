package week29.day75.classwork;

// Q3. Dice Sum
// Given one 6 faced dice and a number N.
// Count the number of ways to get a sum of N 
// if you can roll dice as many times as you want.
public class DiceSumTabulation {

	// TC - O(6 * N) = O(N)
	// SC - O(N)
	public static int countWays(int n) {

		// Initialize dp array
		int[] dp = new int[n + 1];

		dp[0] = 1;
		dp[1] = 1;

		// Iterate over all the possible
		// intermediate values to reach N
		for (int i = 2; i <= n; i++) {
			dp[i] = 0;

			// Calculate the sum for
			// all 6 faces
			for (int j = 1; j <= 6; j++) {
				if (i - j >= 0) {
					dp[i] += dp[i - j];
				}
			}
		}

		return dp[n];
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
