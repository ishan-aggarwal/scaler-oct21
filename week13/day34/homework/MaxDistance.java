package day34.homework;

//Q1. Max Distance

//Problem Description
//
//Given an array A of integers of size N. Find the maximum of value of j - i such that A[i] <= A[j].
//
//
//
//Problem Constraints
//
//1 <= N <= 1000000
//
//-109 <= A[i] <= 109
//
//
//
//Input Format
//
//First argument is an integer array A of size N.
//
//
//
//Output Format
//
//Return an integer denoting the maximum value of j - i.
//
//
//
//Example Input
//
//Input 1:
//
//A = [3, 5, 4, 2]
//
//
//Example Output
//
//Output 1:
//
//2
//
//
//Example Explanation
//
//Explanation 1:
//
//For A[0] = 3 and A[2] = 4, the ans is (2 - 0) = 2. 

public class MaxDistance {
	// DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
	public static int maximumGap(final int[] A) {
		int n = A.length;
		int maxGap = Integer.MIN_VALUE;

		int[] leftMin = new int[n];
		leftMin[0] = A[0];

		for (int i = 1; i < n; i++) {
			leftMin[i] = Math.min(leftMin[i - 1], A[i]);
		}

		int i = n - 1, j = n - 1;

		while (i >= 0 && j >= 0) {

			if (A[j] >= leftMin[i]) {
				maxGap = Math.max(maxGap, j - i);
				i--;
			} else {
				j--;
			}
		}
		return maxGap;
	}

	public static void main(String[] args) {
		int[] A = { 3, 5, 4, 2 };
		System.out.println(maximumGap(A));

		int[] B = { 10, 3, 5, 4, 2, -10, -9, -8, 0, 1, 2, 3, 3 };
		System.out.println(maximumGap(B));

		int[] C = { 10, 3, 5, 4, 2, -10, -9, -8, 0, 1, 2 };
		System.out.println(maximumGap(C));

		int[] D = { 1 };
		System.out.println(maximumGap(D));
	}
}
