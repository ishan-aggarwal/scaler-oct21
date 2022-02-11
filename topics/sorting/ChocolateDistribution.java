package day44.homework;

import java.util.Arrays;

//Q1. Chocolate Distribution

//Problem Description
//
//Given an array A of N integers where each value represents number of chocolates in a packet.
//
//i-th can have A[i] number of chocolates.
//
//There are B number students, the task is to distribute chocolate packets following below conditions:
//
//1. Each student gets one packet.
//2. The difference between the number of chocolates in packet with maximum chocolates and packet with minimum chocolates given to the students is minimum.
//Return the minimum difference (that can be achieved) between maximum and minimum number of chocolates distributed.
//
//
//
//Problem Constraints
//
//0 <= N <= 10^5
//1 <= A[i] <= 10^7
//0 <= B <= 10^5
//
//
//Input Format
//
//The first argument contains an integer array A.
//
//The second argument contains an integer B.
//
//
//
//Output Format
//
//Return the minimum difference (that can be achieved) between maximum and minimum number of chocolates distributed.
//
//
//Example Input
//
//Input:
//
//  A : [3, 4, 1, 9, 56, 7, 9, 12]
//  B : 5
//
//
//Example Output
//
//Output:
//
//  6
//
//
//Example Explanation
//
//Explanation:
//
//  Minimum Difference is 6
//  The set goes like 3,4,7,9,9 and the output is 9-3 = 6

public class ChocolateDistribution {
	public static int solve(int[] A, int B) {
		if (A == null || A.length == 0 || B == 0) {
			return 0;
		}

		Arrays.sort(A);

		int answer = Integer.MAX_VALUE;
		for (int i = 0; i < A.length - B; i++) {
			int diff = A[i + B - 1] - A[i];
			answer = Math.min(answer, diff);
		}

		return answer;
	}

	public static void main(String[] args) {
//		int[] A = { 3, 1, 2 };
//		int B = 0;
//		System.out.println(solve(A, B));
//
//		int[] A1 = { 3, 4, 1, 9, 56, 7, 9, 12 };
//		int B1 = 5;
//		System.out.println(solve(A1, B1));

		int[] A2 = { 5, 10, 15, 25, 26, 27 };
		int B2 = 3;
		System.out.println(solve(A2, B2));

	}
}
