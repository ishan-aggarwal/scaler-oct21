package leetcode.dp;

import java.util.Arrays;

//https://www.codingninjas.com/codestudio/problems/frog-jump_3621012?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos

public class FindMinimumEnergyFrogJump {

	public static int frogJumpRecursive(int ind, int heights[]) {
		if (ind == 0)
			return 0;
		int jumpOne, jumpTwo = Integer.MAX_VALUE;
		jumpOne = Math.abs(heights[ind] - heights[ind - 1]) + frogJumpRecursive(ind - 1, heights);
		if (ind > 1) {
			jumpTwo = Math.abs(heights[ind] - heights[ind - 2]) + frogJumpRecursive(ind - 2, heights);
		}
		return Math.min(jumpOne, jumpTwo);
	}

	// Memoization and recursion are exactly same
	// just persist the results
	// TC - O(N) and SC - O(N) for the dp array and for the recursion call stack
	// Top down approach
	public static int frogJumpMemoization(int ind, int[] height, int[] dp) {
		if (ind == 0)
			return 0;
		if (dp[ind] != -1)
			return dp[ind];
		int jumpTwo = Integer.MAX_VALUE;
		int jumpOne = frogJumpMemoization(ind - 1, height, dp) + Math.abs(height[ind] - height[ind - 1]);
		if (ind > 1)
			jumpTwo = frogJumpMemoization(ind - 2, height, dp) + Math.abs(height[ind] - height[ind - 2]);

		return dp[ind] = Math.min(jumpOne, jumpTwo);
	}

	// TC - O(N) and SC - O(N)
	// bottom up approach
	public static int frogJumpTabulation(int heights[]) {
		int n = heights.length;
		int dp[] = new int[n];
		Arrays.fill(dp, -1);
		dp[0] = 0;
		for (int ind = 1; ind < n; ind++) {
			int jumpTwo = Integer.MAX_VALUE;
			int jumpOne = dp[ind - 1] + Math.abs(heights[ind] - heights[ind - 1]);
			if (ind > 1)
				jumpTwo = dp[ind - 2] + Math.abs(heights[ind] - heights[ind - 2]);

			dp[ind] = Math.min(jumpOne, jumpTwo);
		}
		return dp[n - 1];
	}

	// TC - O(N)
	// SC - O(1)
	public static int frogJump(int heights[]) {
		int n = heights.length;
		int prev = 0;
		int prev2 = 0;
		for (int i = 1; i < n; i++) {
			int jumpTwo = Integer.MAX_VALUE;
			int jumpOne = prev + Math.abs(heights[i] - heights[i - 1]);
			if (i > 1)
				jumpTwo = prev2 + Math.abs(heights[i] - heights[i - 2]);

			int currentI = Math.min(jumpOne, jumpTwo);
			prev2 = prev;
			prev = currentI;
		}
		return prev;
	}

	public static void main(String[] args) {
		int n = 6;
		int[] heights = { 30, 10, 60, 10, 60, 50 };
		System.out.println("--------Recursion---------");
		System.out.println(frogJumpRecursive(n - 1, heights));

		System.out.println("--------Memoization-------");
		// the variable that changes is part of your dp array
		// create a dp array of size (n+1)
		int[] dp = new int[n + 1];
		Arrays.fill(dp, -1);
		int ans = frogJumpMemoization(n - 1, heights, dp);
		System.out.println(ans);
		// since we need to calculate till (n-1)
		// we are interested in printing dp[n-1] also we can take DP array of size n
		// only
		System.out.println(dp[n - 1]);
		System.out.println("--------Tabulation--------");
		System.out.println(frogJumpTabulation(heights));
		System.out.println("----Space Optimization----");
		System.out.println(frogJump(heights));

	}

}
