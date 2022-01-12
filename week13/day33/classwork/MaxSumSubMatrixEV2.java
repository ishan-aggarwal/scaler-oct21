package day33.classwork;

// Q6. MaxSumSubMatrixEV2

// Given a matrix of size (N*M).
// For max sum of any sub-matrix that starts at row 0 and end row can end between 0 to N-1
public class MaxSumSubMatrixEV2 {

	public static void main(String[] args) {

		int mat[][] = { { 0, -2, -7, 0 }, { 9, 2, -6, 2 }, { -4, 1, -4, 1 }, { -1, 8, 0, -2 } };

		System.out.print(maxSumEV2(mat));

	}

	private static int maxSumEV2(int[][] mat) {

		int rows = mat.length;
		int cols = mat[0].length;

		int[] colSum = null;
		int maxSum = Integer.MIN_VALUE;

		for (int eRow = 0; eRow < rows; eRow++) {
			colSum = new int[cols];
			for (int j = 0; j < cols; j++) {
				for (int i = 0; i <= eRow; i++) {
					colSum[j] += mat[i][j];
				}
			}

			int currentSum = 0;
			for (int i = 0; i < colSum.length; i++) {
				currentSum += colSum[i];
				maxSum = Math.max(maxSum, currentSum);
				if (currentSum < 0) {
					currentSum = 0;
				}
			}

		}
		return maxSum;
	}
}
