package day37.assignment;

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

import java.util.ArrayList;
import java.util.Arrays;

public class DivisorsCountTechnique {
	public static ArrayList<Integer> solve(ArrayList<Integer> A) {

		ArrayList<Integer> result = new ArrayList<>();
		int maxElement = findMax(A);

		// least prime factor array
		int[] lpf = new int[maxElement + 1]; // to do index and element mapping

		// initialize array
		for (int i = 0; i < maxElement + 1; i++) {
			lpf[i] = i;
		}

		// prepare least prime factor array
		for (int i = 2; i * i <= maxElement; i++) {
			if (lpf[i] == i) {
				for (int j = i * i; j <= maxElement; j += i) {
					lpf[j] = Math.min(lpf[j], i);
				}
			}
		}

		// prepare the result array
		for (int num : A) {
			int answer = 1;
			while (num > 1) {
				int leastPrimeFactor = lpf[num];
				int count = 0;
				while (num % leastPrimeFactor == 0) {
					count++;
					num /= leastPrimeFactor;
				}
				answer *= (count + 1);
			}
			result.add(answer);
		}
		return result;
	}

	public static int findMax(ArrayList<Integer> A) {
		int maxElement = Integer.MIN_VALUE;
		for (int x : A) {
			maxElement = Math.max(maxElement, x);
		}
		return maxElement;
	}

	public static void main(String[] args) {
//		ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(2, 3, 4, 5));
		ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(8, 9, 10));
		ArrayList<Integer> result = solve(A);
		result.stream().forEach(System.out::println);
	}
}
