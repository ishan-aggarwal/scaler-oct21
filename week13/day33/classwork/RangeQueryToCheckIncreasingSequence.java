package day33.classwork;

//Q2. RangeQueryToCheckIncreasingSequence

// Given an array A of size N and Q queries of range (L,R).
// Return T/F if sub-array from L to R is non-decreasing (increasing) in nature.
// Solution :- O (N) + O (Q)

public class RangeQueryToCheckIncreasingSequence {
	public static boolean[] solve(int[] A, int[][] B) {

		boolean[] res = new boolean[B.length];

		int[] sequencePredictor = new int[A.length];

		sequencePredictor[0] = 0;
		for (int i = 1; i < A.length; i++) {
			if (A[i] < A[i - 1]) {
				sequencePredictor[i] = 1;
			}
		}

		int[] ps = new int[A.length];
		ps[0] = sequencePredictor[0];
		for (int i = 1; i < A.length; i++) {
			ps[i] = sequencePredictor[i] + ps[i - 1];
		}

		for (int i = 0; i < B.length; i++) {

			int left = B[i][0], right = B[i][1];
			int totalOnes = 0;
			if (right - left > 1) {
				totalOnes = ps[right] - ps[left + 1];
			} else {
				totalOnes = ps[right];
			}

			res[i] = (totalOnes >= 1) ? false : true;
		}

		return res;
	}

	public static void main(String[] args) {
		int[] A = { 1, 4, 4, 7, 6, 8, 2, 10, 20, 2 };
		int[][] B = { { 1, 3 }, { 3, 6 }, { 6, 9 } };

		boolean[] res = solve(A, B);
		for (boolean x : res) {
			System.out.print(x + " ");
		}
	}
}
