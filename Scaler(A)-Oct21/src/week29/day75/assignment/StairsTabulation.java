package week29.day75.assignment;

//Q2. Stairs

//Problem Description
//You are climbing a stair case and it takes A steps to reach to the top.
//
//Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
//
//
//
//Problem Constraints
//1 <= A <= 36
//
//
//
//Input Format
//The first and the only argument contains an integer A, the number of steps.
//
//
//
//Output Format
//Return an integer, representing the number of ways to reach the top.
//
//
//
//Example Input
//Input 1:
//
// A = 2
//Input 2:
//
// A = 3
//
//
//Example Output
//Output 1:
//
// 2
//Output 2:
//
// 3
//
//
//Example Explanation
//Explanation 1:
//
// Distinct ways to reach top: [1, 1], [2].
//Explanation 2:
//
// Distinct ways to reach top: [1 1 1], [1 2], [2 1].

public class StairsTabulation {

	// TC - O(N) and SC - O(N)
	public static int climbStairs(int A) {
		// these base cases help to prevent out of bound error
		if (A == 0)
			return 1;
		if (A == 1)
			return 1;
		if (A == 2)
			return 2;

		int[] stepsDP = new int[A + 1];
		stepsDP[0] = 1;
		stepsDP[1] = 1;
		stepsDP[2] = 2;

		for (int i = 3; i <= A; i++) {
			stepsDP[i] = stepsDP[i - 1] + stepsDP[i - 2];
		}

		return stepsDP[A];
	}

	public static void main(String[] args) {
		System.out.println(climbStairs(3));
	}
}
