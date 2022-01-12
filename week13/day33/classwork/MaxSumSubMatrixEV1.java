package day33.classwork;

// Q5. MaxSumSubMatrixEV1

// Given a matrix of size (N*M).
// For max sum of any sub-matrix that starts at row 0 and ends at row N-1

public class MaxSumSubMatrixEV1 {

	public static void main(String[] args) {

		int mat[][] = { { 0, -2, -7, 0 }, { 9, 2, -6, 2 }, { -4, 1, -4, 1 }, { -1, 8, 0, -2 } };

		System.out.print(maxSumEV1(mat));

	}

	private static int maxSumEV1(int[][] mat) {

		int rows = mat.length;
		int cols = mat[0].length;

		int[] colSum = new int[cols];

		for (int j = 0; j < cols; j++) {
			for (int i = 0; i < rows; i++) {
				colSum[j] += mat[i][j];
			}
		}

		int maxSum = Integer.MIN_VALUE;
		int currentSum = 0;

		for (int i = 0; i < colSum.length; i++) {
			currentSum += colSum[i];
			maxSum = Math.max(maxSum, currentSum);
			if (currentSum < 0) {
				currentSum = 0;
			}
		}

		return maxSum;
	}
}
