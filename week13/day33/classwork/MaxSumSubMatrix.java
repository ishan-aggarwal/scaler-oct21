package day33.classwork;

// Q4. MaxSumSubMatrix
// Given a matrix of size (N*M) and Q queries.
// For every query return the sum of sub-matrix bounded by that query

// TC O (MN) + O(Q)
// SC - O(MN) for maintaining extra matrix

public class MaxSumSubMatrix {

	public static void main(String[] args) {

		int mat[][] = { { 0, -2, -7, 0 }, { 9, 2, -6, 2 }, { -4, 1, -4, 1 }, { -1, 8, 0, -2 } };

		int tli = 2, tlj = 2, rbi = 3, rbj = 4;
		System.out.print("\nQuery1: " + sumQuery(mat, tli, tlj, rbi, rbj));

	}

	private static int sumQuery(int[][] mat, int tli, int tlj, int rbi, int rbj) {

		int rows = mat.length;
		int cols = mat[0].length;

		for (int i = 0; i < rows; i++) {
			for (int j = 1; j < cols; j++) {
				mat[i][j] = mat[i][j] + mat[i][j - 1];
			}
		}

		for (int i = 1; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				mat[i][j] = mat[i][j] + mat[i - 1][j];
			}
		}

		int answer = 0;
		if (tli > 0 && tlj > 0) {
			answer = mat[rbi][rbj] - mat[tli - 1][rbj] - mat[rbi][tlj - 1] + mat[tli - 1][tlj - 1];
		} else if (tli == 0 && tlj > 0) {
			answer = mat[rbi][rbj] - mat[rbi][tlj - 1];
		} else if (tli > 0 && tlj == 0) {
			answer = mat[rbi][rbj] - mat[tli - 1][rbj];
		} else if (tli == 0 && tlj == 0) {
			answer = mat[rbi][rbj];
		}

		return answer;
	}
}
