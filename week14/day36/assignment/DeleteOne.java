package day36.assignment;

//Q1. Delete one
//Problem Description
//
//Given an integer array A of size N. You have to delete one element such that the GCD(Greatest common divisor) of the remaining array is maximum.
//
//Find the maximum value of GCD.
//
//
//
//Problem Constraints
//
//2 <= N <= 105
//1 <= A[i] <= 109
//
//
//
//Input Format
//
//First argument is an integer array A.
//
//
//
//Output Format
//
//Return an integer denoting the maximum value of GCD.
//
//
//
//Example Input
//
//Input 1:
//
// A = [12, 15, 18]
//Input 2:
//
// A = [5, 15, 30]
//
//
//Example Output
//
//Output 1:
//
// 6
//Output 2:
//
// 15
//
//
//Example Explanation
//
//Explanation 1:
//
// 
// If you delete 12, gcd will be 3.
// If you delete 15, gcd will be 6.
// If you delete 18, gcd will 3.
// Maximum vallue of gcd is 6.
//Explanation 2:
//
// If you delete 5, gcd will be 15.
// If you delete 15, gcd will be 5.
// If you delete 30, gcd will be 5.

public class DeleteOne {

	public static int solve(int[] A) {
		int n = A.length;
		int[] prefixGCD = new int[n];
		int[] suffixGCD = new int[n];

		int answer = Integer.MIN_VALUE;

		prefixGCD[0] = 0;
		suffixGCD[n - 1] = 0;

		for (int i = 1; i < n; i++) {
			prefixGCD[i] = findGCD(prefixGCD[i - 1], A[i - 1]);
		}

		for (int i = n - 2; i >= 0; i--) {
			suffixGCD[i] = findGCD(suffixGCD[i + 1], A[i + 1]);
		}

		for (int i = 0; i < n; i++) {
			answer = Math.max(answer, findGCD(prefixGCD[i], suffixGCD[i]));
		}
		return answer;
	}

	public static int findGCD(int A, int B) {
		if (A == 0) {
			return B;
		}
		return findGCD(B % A, A);
	}

	public static void main(String[] args) {
		int[] A = { 12, 15, 18 };
		System.out.println(solve(A));
	}
}
