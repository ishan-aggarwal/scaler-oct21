package day35.homework;

import java.util.Arrays;

//Q1. Count of divisors
//Problem Description
//
//Given an array of integers A, find and return the count of divisors of each element of the array.
//
//NOTE: Order of the resultant array should be same as the input array.
//
//
//
//Problem Constraints
//
//1 <= length of the array <= 100000
//1 <= A[i] <= 106
//
//
//
//Input Format
//
//The only argument given is the integer array A.
//
//
//
//Output Format
//
//Return the count of divisors of each element of the array in the form of an array.
//
//
//
//Example Input
//
//Input 1:
//
// A = [2, 3, 4, 5]
//Input 2:
//
// A = [8, 9, 10]
//
//
//Example Output
//
//Output 1:
//
// [2, 2, 3, 2]
//Output 1:
//
// [4, 3, 4]
//
//
//Example Explanation
//
//Explanation 1:
//
// The number of divisors of 2 : [1, 2], 3 : [1, 3], 4 : [1, 2, 4], 5 : [1, 5]
// So the count will be [2, 2, 3, 2].
//Explanation 2:
//
// The number of divisors of 8 : [1, 2, 4, 8], 9 : [1, 3, 9], 10 : [1, 2, 5, 10]
// So the count will be [4, 3, 4].

public class DivisorsCount {
	public static int[] solve(int[] A) {
		int maxElement = getMax(A);
		int[] freq = new int[maxElement + 1];

		// each element has two divisors
		Arrays.fill(freq, 2);

		// update freq for 1
		freq[1] = 1;

		for (int i = 2; i <= maxElement / 2; i++) {
			for (int j = 2 * i; j <= maxElement; j += i) {
				freq[j]++;
			}
		}

		int[] result = new int[A.length];
		int idx = 0;
		for (int x : A) {
			result[idx++] = freq[x];
		}

		return result;

	}

	private static int getMax(int[] A) {
		int max = Integer.MIN_VALUE;
		for (int x : A) {
			max = Math.max(max, x);
		}
		return max;
	}

	public static void main(String[] args) {
		int[] A = { 2, 3, 4, 5 };
		int[] B = solve(A);
		for (int x : B) {
			System.out.print(x + " ");
		}
	}
}
