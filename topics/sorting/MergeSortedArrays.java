package day44.assignment;

//Q1. Merge Two Sorted Arrays

//Problem Description
//
//Given two sorted integer arrays A and B, merge B and A as one sorted array and return it as an output.
//
//
//
//Problem Constraints
//
//-1010 <= A[i],B[i] <= 1010
//
//
//
//Input Format
//
//First Argument is a 1-D array representing A.
//
//Second Argument is also a 1-D array representing B.
//
//
//
//Output Format
//
//Return a 1-D vector which you got after merging A and B.
//
//
//
//Example Input
//
//Input 1:
//
//A = [4, 7, 9 ]
//B = [2 ,11, 19 ]
//Input 2:
//
//A = [1]
//B = [2]
//
//
//Example Output
//
//Output 1:
//
//[2, 4, 7, 9, 11, 19]
//Output 2:
//
//[1, 2]
//
//
//Example Explanation
//
//Explanation 1:
//
//Merging A and B produces the output as described above.
//Explanation 2:
//
// Merging A and B produces the output as described above.

public class MergeSortedArrays {
	// DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
	public static int[] solve(final int[] A, final int[] B) {
		int n = A.length;
		int m = B.length;
		int[] c = new int[n + m];

		int i = 0, j = 0, idx = 0;
		while (i < n && j < m) {
			if (A[i] < B[j]) {
				c[idx++] = A[i++];
			} else {
				c[idx++] = B[j++];
			}
		}

		while (i < n) {
			c[idx++] = A[i++];
		}

		while (j < m) {
			c[idx++] = B[j++];
		}

		return c;
	}

	/*
	 * Merge Sorted Arrays into single arrays of size n+m , TC - O(n + m) SC - O(n +
	 * m) Not in place sorting algorithm
	 */
	public static void main(String[] args) {
		int[] A = { 4, 7, 9 };
		int[] B = { 2, 11, 19 };
		int[] C = solve(A, B);
		for (int x : C) {
			System.out.print(x + " ");
		}
	}
}
