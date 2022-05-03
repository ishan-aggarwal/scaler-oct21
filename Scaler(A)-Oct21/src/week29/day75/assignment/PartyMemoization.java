package week29.day75.assignment;

import java.util.Arrays;

//Q1. Let's Party

//Problem Description
//
//In Danceland, one person can party either alone or can pair up with another person.
//
//Can you find in how many ways they can party if there are A people in Danceland?
//
//Note: Return your answer modulo 10003, as the answer can be large.
//
//
//
//Problem Constraints
//
//1 <= A <= 105
//
//
//
//Input Format
//
//Given only argument A of type Integer, number of people in Danceland.
//
//
//
//Output Format
//
//Return an integer denoting the number of ways people of Danceland can party.
//
//
//
//Example Input
//
//Input 1:
//
// A = 3
//Input 2:
//
// A = 5
//
//
//Example Output
//
//Output 1:
//
// 4
//Output 2:
//
// 26
//
//
//Example Explanation
//
//Explanation 1:
//
// Let suppose three people are A, B, and C. There are only 4 ways to party
// (A, B, C) All party alone
// (AB, C) A and B party together and C party alone
// (AC, B) A and C party together and B party alone
// (BC, A) B and C party together and A
// here 4 % 10003 = 4, so answer is 4.
// 
//Explanation 2:
//
// Number of ways they can party are: 26.

public class PartyMemoization {

	// TC - O(N) and SC - O(N)
	public static int solve(int A) {
		int[] dp = new int[A + 1];
		Arrays.fill(dp, -1);
		return findWays(A, dp);
	}

	private static int findWays(int A, int[] dp) {
		if (A <= 2)
			return A;

		if (dp[A] == -1) {
			dp[A] = (findWays(A - 1, dp) + (A - 1) * findWays(A - 2, dp)) % 10003;
		}

		return dp[A];
	}

	public static void main(String[] args) {
		System.out.println(solve(3));
		System.out.println(solve(4));
	}
}
