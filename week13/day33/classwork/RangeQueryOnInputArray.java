package day33.classwork;

//Q1. RangeQueryOnInputArray

// Given an array A of size N and Q queries of range (L,R).
// Find the sum of the array from L to R.
// Solution :- O (N) + O (Q)

public class RangeQueryOnInputArray {
	public static int[] solve(int[] A, int[][] B) {

		int[] res = new int[B.length];

		int[] ps = new int[A.length];

		ps[0] = A[0];
		for (int i = 1; i < A.length; i++) {
			ps[i] = A[i] + ps[i - 1];
		}

		for (int i = 0; i < B.length; i++) {

			int left = B[i][0], right = B[i][1];

			if (left > 0) {
				res[i] = ps[right] - ps[left - 1];
			} else {
				res[i] = ps[right];
			}
		}
		return res;
	}

	public static void main(String[] args) {
		int[] A = { 3, -2, 1, 4, 2, 6, 2, -4, 2, 8 };
		int[][] B = { { 1, 4 }, { 3, 6 }, { 2, 2 }, { 7, 9 }, { 0, 9 } };

		int[] res = solve(A, B);
		for (int x : res) {
			System.out.print(x + " ");
		}
	}
}
