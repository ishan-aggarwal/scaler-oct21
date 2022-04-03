package leetcode.dp;

import java.util.Arrays;

//70. Climbing Stairs (Easy)

//You are climbing a staircase. It takes n steps to reach the top.
//
//Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
//
// 
//
//Example 1:
//
//Input: n = 2
//Output: 2
//Explanation: There are two ways to climb to the top.
//1. 1 step + 1 step
//2. 2 steps
//Example 2:
//
//Input: n = 3
//Output: 3
//Explanation: There are three ways to climb to the top.
//1. 1 step + 1 step + 1 step
//2. 1 step + 2 steps
//3. 2 steps + 1 step
// 
//
//Constraints:
//
//1 <= n <= 45

public class CountTotalWasyClimbingChairs {

	// This function gives TLE on leetcode
	// TC - exponential
	public static int climbStairsUsingRecursion(int n) {
		if (n == 0)
			return 0;
		if (n == 1)
			return 1;
		if (n == 2)
			return 2;

		return climbStairsUsingRecursion(n - 1) + climbStairsUsingRecursion(n - 2);
	}

	// Here we are using dp array to get the results for already computer indexes
	// TC - O(N) and SC - O(N)
	// Time Complexity: O(N)
	// Reason: The overlapping subproblems will return the answer in constant time
	// O(1). Therefore the total number of new subproblems we solve is ‘n’. Hence
	// total time complexity is O(N).
	//
	// Space Complexity: O(N)
	// Reason: We are using a recursion stack space(O(N)) and an array (again O(N)).
	// Therefore total space complexity will be O(N) + O(N) ≈ O(N)

	public static int climbStairsUsingMemoization(int n, int[] dp) {
		if (n == 0)
			return 0;
		if (n == 1)
			return 1;
		if (n == 2)
			return 2;

		if (dp[n] != -1)
			return dp[n];

		return dp[n] = climbStairsUsingMemoization(n - 1, dp) + climbStairsUsingMemoization(n - 2, dp);
	}

	// Time Complexity: O(N)
	// Reason: We are running a simple iterative loop
	//
	// Space Complexity: O(N)
	// Reason: We are using an external array of size ‘n+1’.
	private static int climbStairsUsingTabulation(int n) {
		int[] dp = new int[n + 1];
		Arrays.fill(dp, -1);
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 2;

		for (int i = 3; i <= n; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}

		return dp[n];
	}

	// Optimal solution
	// TC - O(N)
	// SC - O(1) just using previous two variables
	// Part 3: Space Optimization
	//
	// If we closely look the relation,
	// dp[i] = dp[i-1] + dp[i-2]
	//
	// we see that for any i, we do need only the last two values in the array. So
	// is there a need to maintain a whole array for it?
	// The answer is ‘No’. Let us call dp[i-1] as prev and dp[i-2] as prev2. Now
	// understand the following illustration.

	private static int climbStairs(int n) {

		if (n == 0)
			return 0;
		if (n == 1)
			return 1;
		if (n == 2)
			return 2;

		int prev2 = 1;
		int prev = 2;
		int current = -1;
		for (int i = 3; i <= n; i++) {
			current = prev + prev2;
			prev2 = prev;
			prev = current;
		}

		// both current and previous are pointing to correct answer
		return prev;
//		return current;
	}

	public static void main(String[] args) {
		int n = 12;
		System.out.println("--------Recursion---------");
		System.out.println(climbStairsUsingRecursion(n));
		System.out.println("--------Memoization-------");
		// the variable that changes is part of your dp array
		// create a dp array of size (n+1)
		int[] dp = new int[n + 1];
		Arrays.fill(dp, -1);
		int ans = climbStairsUsingMemoization(n, dp);
		// System.out.println(ans);
		System.out.println(dp[n]);
		System.out.println("--------Tabulation--------");
		System.out.println(climbStairsUsingTabulation(n));
		System.out.println("----Space Optimization----");
		System.out.println(climbStairs(n));
	}

}
