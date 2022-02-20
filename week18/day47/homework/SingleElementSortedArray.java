package day47.homework;

//Q1. Single Element in a Sorted Array

//Problem Description
//
//Given a sorted array of integers A where every element appears twice except for one element which appears once, find and return this single element that appears only once.
//
//NOTE: Users are expected to solve this in O(log(N)) time.
//
//
//
//Problem Constraints
//
//1 <= |A| <= 100000
//
//1 <= A[i] <= 10^9
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
//Return the single element that appears only once.
//
//
//
//Example Input
//
//Input 1:
//
//A = [1, 1, 7]
//Input 2:
//
//A = [2, 3, 3]
//
//
//Example Output
//
//Output 1:
//
// 7
//Output 2:
//
// 2
//
//
//Example Explanation
//
//Explanation 1:
//
// 7 appears once
//Explanation 2:
//
// 2 appears once

public class SingleElementSortedArray {
	public static int solve(int[] A) {
		int n = A.length;
		if (n < 3) {
			return A[0];
		}
		if (A[0] != A[1]) {
			return A[0];
		}
		if (A[n - 1] != A[n - 2]) {
			return A[n - 1];
		}
		int l = 0, r = n - 1;

		while (l <= r) {
			int mid = l + (r - l) / 2;
			if (A[mid] != A[mid - 1] && A[mid] != A[mid + 1]) {
				return A[mid];
			} else if (((mid % 2 == 0) && (A[mid] == A[mid + 1])) || ((mid % 2 != 0) && (A[mid] == A[mid - 1]))) {
				l = mid + 1;
			} else {
				r = mid - 1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] A = { 1, 1, 2, 3, 3, 4, 4, 8, 8 };
//		int[] A = { 1, 1, 2, 2, 3, 3, 4, 4, 8, 8, 10, 10, 11, 12, 12, 14, 14 };
		System.out.println(solve(A));
	}
}
